package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Student;
import org.springframework.objenesis.strategy.StdInstantiatorStrategy;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
    void update(Student student);
}
