package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Struct;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // defining entity manager field
    private EntityManager entityManager;

    // injecting the entityManager field using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {

        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName DESC", Student.class);

        // return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :param", Student.class);

        // Set Parameters
        theQuery.setParameter("param", theLastName);
        // Return Result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
}
