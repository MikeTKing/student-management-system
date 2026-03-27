package com.mikeyy.studentmanagementsystem.controller;

import com.mikeyy.studentmanagementsystem.dto.EnrollmentDto;
import com.mikeyy.studentmanagementsystem.dto.GradeReportDto;
import com.mikeyy.studentmanagementsystem.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentDto enroll(@RequestBody EnrollmentDto dto) {
        return enrollmentService.enroll(dto);
    }

    @GetMapping("/average-grades")
    public List<GradeReportDto> averageGrades() {
        return enrollmentService.averageGradesPerCourse();
    }
}