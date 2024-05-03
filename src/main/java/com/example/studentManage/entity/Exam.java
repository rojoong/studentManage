package com.example.studentManage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Exam {
    @Id
    @Column(length = 6, nullable = false)
    private String exam_no;

    @Column(length = 10)
    private int kor;

    @Column(length = 15)
    private int math;

    @Column(length = 4)
    private int eng;

    @Column(length = 20)
    private int his;
}
