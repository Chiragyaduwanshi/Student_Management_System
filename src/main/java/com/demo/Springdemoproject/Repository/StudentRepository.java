package com.demo.Springdemoproject.Repository;

import com.demo.Springdemoproject.Pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Integer> {

}
