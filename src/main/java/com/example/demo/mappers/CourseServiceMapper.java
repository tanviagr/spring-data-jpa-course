package com.example.demo.mappers;

import com.example.demo.entities.Course;
import com.example.demo.pojos.CourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseServiceMapper {
    CourseDto convertCourseToCourseDto(final Course course);
}
