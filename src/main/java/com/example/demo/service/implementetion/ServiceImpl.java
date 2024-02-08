package com.example.demo.service.implementetion;

import com.example.demo.dto.StudentCoursesDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Student;
import com.example.demo.mapper.EntityMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service {

    @Autowired
    private EntityMapper entityMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public void addStudent(Student student) {
        student.setTime_created(LocalDate.now());
        studentRepository.save(student);
    }

    @Override
    public void addCourse(Courses courses, Long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        if(instructorOptional.isEmpty()){
            throw new EntityNotFoundException();
        }
        Instructor instructor = instructorOptional.get();

        courses.setInstructor(instructor);
        instructor.getCourses().add(courses);
        courses.setTime_created(LocalDate.now());
        courseRepository.save(courses);
        instructorRepository.save(instructor);
    }

    @Override
    public void addInstructor(Instructor instructor) {
        instructor.setTime_created(LocalDate.now());
        instructorRepository.save(instructor);
    }

    @Override
    public List<StudentDto> fetchStudentList() {
        return entityMapper.mapToStudentDtoList(studentRepository.findAll());
    }



    @Override
    public void createHtmlFile(List<StudentDto> studentList) {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n")
                .append("<table>\n")
                .append("<tr>\n")
                .append("<th>Student</th>\n")
                .append("<th>Total Credit</th>\n")
                .append("</tr>\n")
                .append("<tr>\n")
                .append("<th></th>\n")
                .append("<th>Course Name</th>\n")
                .append("<th>Time</th>\n")
                .append("<th>Credit</th>\n")
                .append("<th>Instructor</th>\n")
                .append("</tr>\n");

        studentList.stream().forEach(studentDto -> {
            htmlContent.append("<tr>\n");
            htmlContent.append("<td>").append(studentDto.getFirst_name()+" "+studentDto.getLast_name()).append("</td>\n");
            htmlContent.append("<td>").append(allCredits(studentDto.getCourses())).append("</td>\n");
            htmlContent.append("</tr>\n");
            studentDto.getCourses().stream().forEach(studentCoursesDto -> {
                htmlContent.append("<tr>\n");
                htmlContent.append("<td></td>\n");
                htmlContent.append("<td>").append(studentCoursesDto.getCoursesDto().getName()).append("</td>\n");
                htmlContent.append("<td>").append(studentCoursesDto.getCoursesDto().getTotal_time()).append("</td>\n");
                htmlContent.append("<td>").append(studentCoursesDto.getCoursesDto().getCredit()).append("</td>\n");
                htmlContent.append("<td>")
                        .append(studentCoursesDto.getCoursesDto().getInstructor().getFirst_name() +" ")
                        .append(studentCoursesDto.getCoursesDto().getInstructor().getLast_name())
                        .append("</td>\n");
            });

        });
        htmlContent.append("</table>");

        File file = new File("report.html");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(htmlContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int allCredits(List<StudentCoursesDto> studentCourses) {
        return studentCourses.stream().mapToInt(studentCourse -> studentCourse.getCoursesDto()
                .getCredit())
                .sum();

    }


}
