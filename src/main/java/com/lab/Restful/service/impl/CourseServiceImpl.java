package com.lab.Restful.service.impl;

import com.lab.Restful.entity.Course;
import com.lab.Restful.repo.CourseRepo;
import com.lab.Restful.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;//final not static

    @Override
    public void save(Course c) {
        Course cr=new Course();
        cr.setId(c.getId());
        cr.setName(c.getName());
        cr.setCode(c.getCode());
        courseRepo.save(cr);
    }

    @Override
    public void update(Course c, int id) {
        List<Course> courseList= courseRepo.findAllById(id);
        for(Course cr : courseList){
            //cr.setId(c.getId());
            cr.setName(c.getName());
            cr.setCode(c.getCode());
        }
        courseRepo.saveAll(courseList);
    }

    @Override
    public void delete(int id) {
        courseRepo.deleteById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course getById(int id) {
        return courseRepo.findAllById(id).get(0);
    }
}
