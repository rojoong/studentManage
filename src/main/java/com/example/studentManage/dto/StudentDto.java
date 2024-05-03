package com.example.studentManage.dto;

import com.example.studentManage.constant.Gender;
import com.example.studentManage.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private String student_no;
    private String name;
    private String phone;
    private Gender gender;
    private String address;
    ExamDto exam;

//    public StudentDto(String student_no, String name, String phone, Gender gender, String address) {
//        this.student_no = student_no;
//        this.name = name;
//        this.phone = phone;
//        this.gender = gender;
//        this.address = address;
//    }

    public static StudentDto from(Student student) {
        return new StudentDto(student.getStudent_no(), student.getName(),
                student.getPhone(), student.getGender(), student.getAddress(), new ExamDto());
    }
}
