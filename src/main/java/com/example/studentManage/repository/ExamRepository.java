package com.example.studentManage.repository;

import com.example.studentManage.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExamRepository extends JpaRepository<Exam, String> {
    @Query(value = "select sum(exam_no) as exam_no, sum(kor) as kor, sum(math) as math, sum(eng) as eng, sum(his) as his from exam", nativeQuery = true)
    Exam sum();
}
