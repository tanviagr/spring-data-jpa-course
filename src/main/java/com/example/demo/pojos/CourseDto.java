package com.example.demo.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CourseDto {
    private String courseName;
    private Integer credits;

    public CourseDto(String courseName, Integer credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public CourseDto() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
