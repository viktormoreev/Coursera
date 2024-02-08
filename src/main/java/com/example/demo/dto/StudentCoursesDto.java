package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCoursesDto {
    //This dto is created to support the search that we need to do
    private CoursesDto coursesDto;

    private LocalDate completion_date;
}
