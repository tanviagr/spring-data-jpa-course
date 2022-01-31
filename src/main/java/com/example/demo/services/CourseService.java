package com.example.demo.services;

import com.example.demo.entities.Course;
import com.example.demo.mappers.CourseServiceMapper;
import com.example.demo.pojos.CourseDto;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseServiceMapper mapper;

    public List<CourseDto> getAllCoursesContainingName(String infix)
    {
        List<Course> courses =  courseRepository.findByCourseNameContaining(infix);
        return courses.stream().map(course -> mapper.convertCourseToCourseDto(course)).collect(Collectors.toList());
    }
}
