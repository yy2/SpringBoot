package com.yy2.demo.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentDataAccessService {

    private Student student1 = new Student(UUID.randomUUID(), "Jake", "Roo", "jakeroo@gmail.com", Student.Gender.MALE);
    private Student student2 = new Student(UUID.randomUUID(), "Amy", "Roo", "amyroo@gmail.com", Student.Gender.FEMALE);
    private final List<Student> listOfStudents = new ArrayList<>(Arrays.asList(student1, student2));

    public List<Student> selectAllStudents() {
        return listOfStudents;
    }
}
