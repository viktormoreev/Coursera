package com.example.demo.dto;

import com.example.demo.entity.StudentCourses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private String pin;
    private String first_name;
    private String last_name;
    private LocalDate time_created;

    private List<StudentCoursesDto> courses;
}
