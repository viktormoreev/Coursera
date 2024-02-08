package com.example.demo.dto;

import com.example.demo.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDto {
    private Long id;
    private String name;
    private InstructorDto instructor;
    private short total_time;
    private short credit;
    private LocalDate time_created ;
}
