package com.example.demo.mapper;

import com.example.demo.dto.CoursesDto;
import com.example.demo.dto.InstructorDto;
import com.example.demo.dto.StudentCoursesDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentCourses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityMapper {

    public List<StudentDto> mapToStudentDtoList(List<Student> students){
        return students.stream().map(this::mapToStudentDto).collect(Collectors.toList());
    }

    public StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setTime_created(student.getTime_created());
        studentDto.setFirst_name(student.getFirst_name());
        studentDto.setLast_name(student.getLast_name());
        studentDto.setPin(student.getPin());
        studentDto.setCourses(mapToStudentCoursesDtoList(student.getStudentCourses()));
        return studentDto;
    }

    public StudentCoursesDto mapToStudentCoursesDto(StudentCourses studentCourses){
        StudentCoursesDto studentCoursesDto = new StudentCoursesDto();
        studentCoursesDto.setCompletion_date(studentCourses.getCompletion_date());
        studentCoursesDto.setCoursesDto(mapToCoursesDto(studentCourses.getCourses()));
        return studentCoursesDto;
    }

    public List<StudentCoursesDto> mapToStudentCoursesDtoList (List<StudentCourses> studentCourses){
        return studentCourses.stream().map(this::mapToStudentCoursesDto).collect(Collectors.toList());
    }

    public CoursesDto mapToCoursesDto(Courses courses){
        CoursesDto coursesDto = new CoursesDto();
        coursesDto.setId(courses.getId());
        coursesDto.setName(courses.getName());
        coursesDto.setCredit(courses.getCredit());
        coursesDto.setTime_created(courses.getTime_created());
        coursesDto.setTotal_time(courses.getTotal_time());
        coursesDto.setInstructor(mapToInstructorDto(courses.getInstructor()));
        return coursesDto;
    }

    public InstructorDto mapToInstructorDto(Instructor instructor){
        InstructorDto instructorDto= new InstructorDto();
        instructorDto.setFirst_name(instructor.getFirst_name());
        instructorDto.setLast_name(instructor.getLast_name());
        instructorDto.setTime_created(instructor.getTime_created());
        instructorDto.setId(instructor.getId());
        return instructorDto;
    }


}
