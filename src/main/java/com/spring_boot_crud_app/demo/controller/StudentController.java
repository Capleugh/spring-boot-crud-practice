package com.spring_boot_crud_app.demo.controller;
// you could choose to call this package and class resource instead of controller

import com.spring_boot_crud_app.demo.model.Student;
import com.spring_boot_crud_app.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
// this annotation indicates that this class will serve as a RESTful API that we can hit
// any method that we define with the correct annotations inside this class can be consumed by any client
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    lines 17-21 allow us to instantiate our Student Service
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
