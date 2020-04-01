package com.yy2.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentDataAccessService {

    private final JdbcTemplate jdbcTemplate;

//    private Student student1 = new Student(UUID.randomUUID(), "Jake", "Roo", "jakeroo@gmail.com", Student.Gender.MALE);
//    private Student student2 = new Student(UUID.randomUUID(), "Amy", "Roo", "amyroo@gmail.com", Student.Gender.FEMALE);
//    private final List<Student> listOfStudents = new ArrayList<>(Arrays.asList(student1, student2));

    @Autowired
    public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> selectAllStudents() {
        String sql ="" +
                "SELECT student_id, first_name, last_name, email, gender FROM student";
        List<Student> listOfStudents = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                String studentIdStr = rs.getString("student_id");
                UUID studentId = UUID.fromString(studentIdStr);
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String genderStr = rs.getString("gender").toUpperCase();
                Student.Gender gender = Student.Gender.valueOf(genderStr);
                Student student = new Student(studentId, firstName, lastName, email, gender);
                return student;
            }
        });

        return listOfStudents;
    }

    int insertStudent(UUID newStudentId, Student student) {
        String sql = "" +
                "INSERT INTO student(student_id, first_name, last_name, email, gender) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, newStudentId, student.getFirstName(), student.getLastName(), student.getEmail(), student.getGender().name().toUpperCase());
    }
}
