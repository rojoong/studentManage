package com.example.studentManage.dto;

import com.example.studentManage.entity.Exam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamDto {
    private String exam_no;
    private int kor;
    private int math;
    private int eng;
    private int his;
    private int sum;
    private double avg;
    private int rank;

    public ExamDto(String examNo, int kor, int math, int eng, int his) {
    }
    private static ExamDto convert(Exam exam){
        return ExamDto.builder().exam_no(exam.getExam_no())
                .kor(exam.getKor()).math(exam.getMath())
                .eng(exam.getEng()).his(exam.getHis())
                .build();
    }

    public static ExamDto from(Exam exam) {
        return new ExamDto(exam.getExam_no(), exam.getKor(), exam.getMath(),
                exam.getEng(), exam.getHis());
    }
}
