package com.example.studentManage.controller;

import com.example.studentManage.dto.ExamDto;
import com.example.studentManage.dto.StudentDto;
import com.example.studentManage.entity.Student;
import com.example.studentManage.service.ExamService;
import com.example.studentManage.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final ExamService examService;

    public StudentController(StudentService studentService, ExamService examService) {
        this.studentService = studentService;
        this.examService = examService;
    }

    @GetMapping("main")
    public String showAll() {
        return "/students/main";
    }

    @GetMapping("list")
    public String listView(Model model) {
        List<StudentDto> dtoList = studentService.findAll();
        model.addAttribute("dto", dtoList);
        return "/students/list";
    }

    @GetMapping("grade")
    public String getStudentGrades(Model model) {

        List<StudentDto> studentDtoList = new ArrayList<>();
        studentDtoList = studentService.findStudentWithGrades();
        model.addAttribute("students", studentDtoList);

        ExamDto examDto = examService.sum();
        log.info(examDto.toString());

        model.addAttribute("examDto", examDto);
        return "/students/grade";
    }
}
