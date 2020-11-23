package com.spring_boot_crud_app.demo.controller;
// you could choose to call this package and class resource instead of controller

import com.spring_boot_crud_app.demo.model.Student;
import com.spring_boot_crud_app.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public void insertNewStudent(@RequestBody Student student) {
        studentService.persistNewStudent(UUID.randomUUID(), student);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )

    public Student getStudent(@PathVariable("studentId") UUID studentId) {
        return  studentService.getStudentById(studentId);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )

    public void updateStudent(@PathVariable("studentId") UUID studentId, @RequestBody Student studentUpdate) {
        studentService.updateStudentById(studentId, studentUpdate);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )

    public void deleteStudent(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudentById(studentId);
    }
}
