package com.lab.Restful.service.impl;

import com.lab.Restful.entity.Course;
import com.lab.Restful.entity.Student;
import com.lab.Restful.repo.StudentRepo;
import com.lab.Restful.service.CourseService;
import com.lab.Restful.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final CourseService courseService;


    @Override
    public void save(Student s) {
        Student st=new Student();
        st.setId(s.getId());
        st.setFirstName(s.getFirstName());
        st.setLastName(s.getLastName());
        st.setEmail(s.getEmail());
        st.setMajor(s.getMajor());
        studentRepo.save(st);
    }

    @Override
    public void update(Student s, int id){
        Student st= studentRepo.findById(id);
        st.setId(st.getId());//id cannot change**
        st.setFirstName(s.getFirstName());
        st.setLastName(s.getLastName());
        st.setEmail(s.getEmail());
        st.setMajor(s.getMajor());
        studentRepo.save(st);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.findAllByMajor(major);
    }
    @Override
    public void addClassById(int studentId, int courseId){
        Course c=courseService.getById(courseId);
        Student st= studentRepo.findById(studentId);
        st.getCoursesTaken().add(c);
        studentRepo.save(st);

    }
    @Override
    public List<Course> getCoursesById(int id){
        return studentRepo.findById(id).getCoursesTaken();
    }
}
