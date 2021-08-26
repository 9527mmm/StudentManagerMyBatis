package com.zxk.service;

import com.zxk.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();

    Integer delete(Integer id);

    Student selectByID(Integer id);

    Integer update(Student student);

    Integer insert(Student student);


    List<Student> selectConditions(String name, String score);
}
