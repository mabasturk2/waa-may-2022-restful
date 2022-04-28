package com.lab.Restful.service;

import com.lab.Restful.entity.Course;
import com.lab.Restful.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student s);
    void update(Student s, int id);
    void delete(int id);
    List<Student> getAll();
    Student getById(int id);
    List<Student> getStudentsByMajor(String major);
    void addClassById(int studentId, int courseId);
    List<Course> getCoursesById(int id);
}

