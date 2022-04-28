package com.lab.Restful.service;

import com.lab.Restful.entity.Course;

import java.util.List;

public interface CourseService {
        void save(Course c);
        void update(Course c, int id);
        void delete(int id);
        List<Course> getAll();
        Course getById(int id);

}
