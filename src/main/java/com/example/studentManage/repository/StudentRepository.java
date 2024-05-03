package com.example.studentManage.repository;

import com.example.studentManage.entity.Exam;
import com.example.studentManage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
}
