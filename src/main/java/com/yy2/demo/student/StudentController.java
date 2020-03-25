package com.yy2.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class StudentController {
//    private Student student1 = new Student(UUID.randomUUID(), "Jake", "Roo", "jakeroo@gmail.com", Student.Gender.MALE);
//    private Student student2 = new Student(UUID.randomUUID(), "Amy", "Roo", "amyroo@gmail.com", Student.Gender.FEMALE);
//    private final List<Student> listOfStudents = new ArrayList<>(Arrays.asList(student1, student2));

//    public void createDefaultStudents() {
//        listOfStudents.add();
//        listOfStudents.add(new Student(UUID.randomUUID(), "Amy", "Roo", "amyroo@gmail.com", Student.Gender.FEMALE));
//    }

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        //createDefaultStudents();
        return studentService.getAllStudents();
    }
}
