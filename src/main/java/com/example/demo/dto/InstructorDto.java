package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDto {
    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate time_created ;
}
