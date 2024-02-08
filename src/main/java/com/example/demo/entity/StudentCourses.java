package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentCourses {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Courses courses;

    private LocalDate completion_date;
}
