package com.example.demo.controller;

import com.example.demo.pojos.CourseDto;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("courses/")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("getAllCourses")
    public List<CourseDto> getAllCoursesContainingName(@RequestParam String infix)
    {
        return courseService.getAllCoursesContainingName(infix);
    }
}
