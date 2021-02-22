package org.sussanacode.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Nadia Osman"),
            new Student(2,"Sara White"),
            new Student(3,"Andy Harris"),
            new Student(4,"Amanda Jones")
    );


    //get all student record
    //hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hadAnyAuthority('permission')

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINASSISTANT')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    //add new student entity
    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);

    }


    //edit a record in the student database
    @PutMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void editStudent(@PathVariable("studentId")Integer studentId, @RequestBody Student student){
        System.out.println(studentId + "\n" + student);
    }

    //delete a student record
    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
    }

}
