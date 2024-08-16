package com.mostafaesmail.cruddemo.dao;

import java.util.List;
import com.mostafaesmail.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(int id);
    int deleteAll();
}
