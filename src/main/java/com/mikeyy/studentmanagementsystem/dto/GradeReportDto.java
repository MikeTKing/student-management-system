package com.mikeyy.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeReportDto {
    private Long courseId;
    private Double averageGrade;
    private Long studentCount;
}
