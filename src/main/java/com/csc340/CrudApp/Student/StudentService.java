package com.csc340.CrudApp.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;

    public List<Student> getAllStudents() { return repo.findAll(); }

    public Student getStudent(long id) { return repo.getStudentById(id); }

    public void deleteStudent(long id) { repo.deleteStudentById(id); }

    public void saveStudent(Student student) { repo.saveStudent(student); }

    public void updateUser(Student student) { repo.updateStudent(student); }
}
