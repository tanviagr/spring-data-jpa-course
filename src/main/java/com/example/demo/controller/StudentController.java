package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(path = "hello-world")
    public String helloWorld()
    {
        return "Hello World!";
    }

    @GetMapping(path = "get_students")
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }

    @PostMapping(path = "save_student")
    public Student saveStudent(@RequestBody Student student)
    {
        System.out.println(student);
        return studentService.saveStudent(student);
    }
}
