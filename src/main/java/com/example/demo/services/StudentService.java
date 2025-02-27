package com.example.demo.services;

import com.example.demo.entities.Country;
import com.example.demo.entities.Student;
import com.example.demo.pojos.StudentRequest;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CountryRepository countryRepository;

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findAllByFirstName(firstName);
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public Student saveStudentByPojo(StudentRequest studentRequest) {
        Country studentCountry = countryRepository.findByCountryId(studentRequest.getCountryId());
        Student student = new Student(studentRequest.getFirstName(),
                studentRequest.getLastName(),
                studentRequest.getAge(),
                studentRequest.getEmail(),
                studentRequest.getField(),
                studentCountry);
        return studentRepository.save(student);
    }
}
