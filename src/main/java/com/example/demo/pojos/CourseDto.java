package com.example.demo.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CourseDto {
    private String courseNameDto;
    private Integer creditsDto;

    public CourseDto(String courseNameDto, Integer creditsDto) {
        this.courseNameDto = courseNameDto;
        this.creditsDto = creditsDto;
    }

    public CourseDto() {
    }

    public String getCourseNameDto() {
        return courseNameDto;
    }

    public void setCourseNameDto(String courseNameDto) {
        this.courseNameDto = courseNameDto;
    }

    public Integer getCreditsDto() {
        return creditsDto;
    }

    public void setCreditsDto(Integer creditsDto) {
        this.creditsDto = creditsDto;
    }
}
