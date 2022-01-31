package com.example.demo.mappers;

import com.example.demo.entities.Course;
import com.example.demo.pojos.CourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CourseServiceMapper {
    @Mappings({
            @Mapping(target = "courseNameDto", source = "course.courseName"),
            @Mapping(target = "creditsDto", source = "course.credits")
    }
    )
    CourseDto convertCourseToCourseDto(final Course course);
}
