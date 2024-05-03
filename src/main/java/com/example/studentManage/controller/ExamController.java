package com.example.studentManage.controller;

import com.example.studentManage.dto.ExamDto;
import com.example.studentManage.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")

public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("dto", new ExamDto());
        return "students/insert";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute("dto")ExamDto dto) {
        examService.insert(dto);
        return "redirect:/students/main";
    }

//    @GetMapping("/grade")
//    public String grade(Model model) {
//        List<ExamDto> dtoList = examService.findAll();
//        System.out.printf(dtoList.toString());
//        model.addAttribute("dto", dtoList);
//        return "/students/grade";
//    }
}
