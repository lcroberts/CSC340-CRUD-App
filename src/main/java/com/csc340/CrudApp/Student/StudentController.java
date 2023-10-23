package com.csc340.CrudApp.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("studentList", service.getAllStudents());
        return "student/list-students";
    }

    @GetMapping("/id={id}")
    public String getStudent(@PathVariable long id, Model model) {
        model.addAttribute("student", service.getStudent(id));
        return "student/student-detail";
    }

    @GetMapping("/delete/id={id}")
    public String deleteUser(@PathVariable long id) {
        service.deleteStudent(id);
        return "redirect:/student/all";
    }

    @PostMapping("/create")
    public String createStudent(Student student) {
        service.saveStudent(student);
        return "redirect:/user/all";
    }

    @PostMapping("/update")
    public String updateStudent(Student student) {
        service.updateUser(student);
        return "redirect:/student/all";
    }

    @GetMapping("/new-student")
    public String newStudentForm() { return "student/new-student"; }

    @GetMapping("/update/id={id}")
    public String updateStudentForm(@PathVariable long id, Model model) {
        model.addAttribute("student", service.getStudent(id));
        return "student/update-student";
    }
}
