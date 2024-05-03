package com.example.studentManage.service;

import com.example.studentManage.dto.ExamDto;
import com.example.studentManage.dto.StudentDto;
import com.example.studentManage.entity.Exam;
import com.example.studentManage.entity.Student;
import com.example.studentManage.repository.ExamRepository;
import com.example.studentManage.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;


    public StudentService(StudentRepository studentRepository, ExamRepository examRepository) {
        this.studentRepository = studentRepository;
        this.examRepository = examRepository;
    }

    public List<StudentDto> findAll() {
        List<StudentDto> dtoList = new ArrayList<>();
        dtoList = studentRepository.findAll()
                .stream()
                .map(x -> StudentDto.from(x))
                .toList();
        return dtoList;
    }

    public List<StudentDto> findStudentWithGrades() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (int i = 0; i < studentList.size(); i++) {
            String id = studentList.get(i).getStudent_no();
            ExamDto examDto = new ExamDto();
            Exam exam = examRepository.findById(id).orElse(null);
            StudentDto studentDto = new StudentDto();
            studentDto.setStudent_no(id);
            studentDto.setName(studentList.get(i).getName());
            if (exam != null) {
                examDto.setExam_no(id);
                examDto.setKor(exam.getKor());
                examDto.setMath(exam.getMath());
                examDto.setEng(exam.getEng());
                examDto.setHis(exam.getHis());
                studentDto.setExam(examDto);

                int sum = exam.getKor() + exam.getMath() + exam.getEng() + exam.getHis();
                examDto.setSum(sum);

                double avg = sum / 4.0;
                examDto.setAvg(avg);

                studentDto.setExam(examDto);
            }
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }
}
