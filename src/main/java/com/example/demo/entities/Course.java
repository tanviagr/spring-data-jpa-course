package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "courses", schema = "public")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name", nullable = false, unique = true, length = 10)
    private String courseName;

    @Column(name = "course_credits", nullable = false)
    private Integer credits;

    @Column(name = "course_teacher_name", nullable = false)
    private String teacherName;

    //instructor
    //timetable
    //credits

    public Course(Integer id, String courseName, Integer credits, String teacherName) {
        this.id = id;
        this.courseName = courseName;
        this.credits = credits;
        this.teacherName = teacherName;
    }

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
