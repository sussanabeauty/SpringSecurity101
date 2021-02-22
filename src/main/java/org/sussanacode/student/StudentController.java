package org.sussanacode.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Nadia Osman"),
            new Student(2,"Sara White"),
            new Student(3,"Andy Harris"),
            new Student(4,"Amanda Jones")
    );


    @GetMapping(path="/{studentId}")
    public Student getStudents(@PathVariable("studentId") Integer studentId){
            return STUDENTS.stream()
                            .filter(student -> studentId.equals(student.getStudentId()))
                            .findFirst()
                            .orElseThrow(() -> new IllegalStateException("Student" + studentId + "does not exist." ));
    }

}
