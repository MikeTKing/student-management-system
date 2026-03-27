package com.mikeyy.studentmanagementsystem.dto;

import lombok.Data;

@Data
public class EnrollmentDto {
    private Long id;
    private Long studentId;
    private Long courseId;
    private Double grade;
}
