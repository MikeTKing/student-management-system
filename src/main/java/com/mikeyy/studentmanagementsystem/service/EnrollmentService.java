package com.mikeyy.studentmanagementsystem.service;



import com.mikeyy.studentmanagementsystem.dto.EnrollmentDto;
import com.mikeyy.studentmanagementsystem.dto.GradeReportDto;
import com.mikeyy.studentmanagementsystem.entity.Course;
import com.mikeyy.studentmanagementsystem.entity.Enrollment;
import com.mikeyy.studentmanagementsystem.entity.Student;
import com.mikeyy.studentmanagementsystem.repository.CourseRepository;
import com.mikeyy.studentmanagementsystem.repository.EnrollmentRepository;
import com.mikeyy.studentmanagementsystem.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public EnrollmentDto enroll(EnrollmentDto dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        Enrollment enrollment = enrollmentRepository
                .findByStudentAndCourse(student, course)
                .orElse(Enrollment.builder()
                        .student(student)
                        .course(course)
                        .build());

        enrollment.setGrade(dto.getGrade());
        Enrollment saved = enrollmentRepository.save(enrollment);
        dto.setId(saved.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GradeReportDto> averageGradesPerCourse() {
        return enrollmentRepository.findAverageGradesPerCourse();
    }
}
