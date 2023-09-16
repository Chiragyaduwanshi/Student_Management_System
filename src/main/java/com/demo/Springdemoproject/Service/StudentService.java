package com.demo.Springdemoproject.Service;

import com.demo.Springdemoproject.Pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    Student getStudentById(Integer id);

    void deleteStudent(Integer id);
}
