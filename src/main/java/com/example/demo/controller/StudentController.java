package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.pojos.StudentRequest;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(path = "hello-world")
    public String helloWorld()
    {
        return "Hello World!";
    }

    @GetMapping(path = "getStudents")
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }

    @PostMapping(path = "saveStudent")
    public Student saveStudent(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @PostMapping(path = "saveStudentByPojo")
    public Student saveStudentByPojo(@RequestBody StudentRequest studentRequest)
    {
        return studentService.saveStudentByPojo(studentRequest);
    }

    @GetMapping(path = "getStudentByFirstName")
    public List<Student> getStudentByName(String firstName)
    {
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping(path = "getStudentByEmail")
    public Student getStudentByEmail(String email)
    {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("getStudentsWithCountry")
    public List<Object> getStudentsWithCountry()
    {
        return studentRepository.getStudentWithCountry();
    }
}
