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
public class Student {

    @Id
    private String pin;
    private String first_name;
    private String last_name;
    private LocalDate time_created;

    @OneToMany(mappedBy = "student")
    private List<StudentCourses> studentCourses;

}
