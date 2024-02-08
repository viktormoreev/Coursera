package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Student;
import com.example.demo.service.Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    /*
    Usually I do make controller for each class, but because there
    are no going be a lot of calls I will make just one for all
     */

    @Autowired
    private Service service;

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@Valid @RequestBody Student student){
        service.addStudent(student);
        return ResponseEntity.ok("Student created successfully!");
    }

    @PostMapping("/add_course_to_instructor/{instructorId}")
    public ResponseEntity<String> addCourse(@Valid @RequestBody Courses courses, @PathVariable Long instructorId){
        service.addCourse(courses, instructorId);
        return ResponseEntity.ok("Course created successfully!");
    }

    @PostMapping("/instructor")
    public ResponseEntity<String> addInstructor(@Valid @RequestBody Instructor instructor){
        service.addInstructor(instructor);
        return ResponseEntity.ok("Course created successfully!");
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> fetchStudentList(){
       List<StudentDto> studentList = service.fetchStudentList();
       service.createHtmlFile(studentList);
       return ResponseEntity.ok(studentList);
    }

}
