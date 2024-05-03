package com.example.studentManage.service;

import com.example.studentManage.dto.ExamDto;
import com.example.studentManage.dto.StudentDto;
import com.example.studentManage.entity.Exam;
import com.example.studentManage.repository.ExamRepository;
import com.example.studentManage.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public void insert(ExamDto examDto) {
        Exam exam = Exam.builder()
                .exam_no(examDto.getExam_no())
                .kor(examDto.getKor())
                .math(examDto.getMath())
                .eng(examDto.getEng())
                .his(examDto.getHis())
                .build();
        examRepository.save(exam);
    }

    public List<ExamDto> findAll() {
        List<ExamDto> dtoList = new ArrayList<>();
        dtoList = examRepository.findAll()
                .stream()
                .map(x -> ExamDto.from(x))
                .toList();
        return dtoList;
    }

    public ExamDto sum() {
        Exam exam = examRepository.sum();
        return ExamDto.builder().exam_no(exam.getExam_no())
                .kor(exam.getKor()).math(exam.getMath())
                .eng(exam.getEng()).his(exam.getHis())
                .build();
    }
}
