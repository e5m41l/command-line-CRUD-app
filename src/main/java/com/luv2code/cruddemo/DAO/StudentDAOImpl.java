package com.mostafaesmail.cruddemo.dao;

import com.mostafaesmail.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);

        return student;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);

        List<Student> students = query.getResultList();

        return students;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName =:theData", Student.class);

        // set parameter
        query.setParameter("theData", lastName);

        // return result
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        // get the student
        Student x = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(x);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numOfRows;
    }
}
