package com.example.demo.service;

import com.example.demo.dto.StudentCoursesDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Student;

import java.util.List;

public interface Service {
    void addStudent(Student student);

    void addCourse(Courses courses, Long instructorId);

    void addInstructor(Instructor instructor);

    List<StudentDto> fetchStudentList();

    void createHtmlFile(List<StudentDto> studentList);

    int allCredits(List<StudentCoursesDto> studentCoursesDto);
}
