package com.mikeyy.studentmanagementsystem.repository;


import com.mikeyy.studentmanagementsystem.dto.GradeReportDto;
import com.mikeyy.studentmanagementsystem.entity.Course;
import com.mikeyy.studentmanagementsystem.entity.Enrollment;
import com.mikeyy.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Optional<Enrollment> findByStudentAndCourse(Student student, Course course);

    @Query("select new com.mikeyy.studentmanagementsystem.dto.GradeReportDto(e.course.id, avg(e.grade), count(e.student.id)) " +
            "from Enrollment e where e.grade is not null group by e.course.id")
    List<GradeReportDto> findAverageGradesPerCourse();
}
