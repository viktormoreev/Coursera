package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "courses")
    private List<StudentCourses> studentCoursesList;
    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;
    private short total_time;
    private short credit;
    private LocalDate time_created ;
}
