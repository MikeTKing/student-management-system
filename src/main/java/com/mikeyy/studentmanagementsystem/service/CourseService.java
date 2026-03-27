package com.mikeyy.studentmanagementsystem.service;

import com.mikeyy.studentmanagementsystem.dto.CourseDto;
import com.mikeyy.studentmanagementsystem.entity.Course;
import com.mikeyy.studentmanagementsystem.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public Page<CourseDto> list(Pageable pageable) {
        return courseRepository.findAll(pageable).map(this::toDto);
    }

    @Transactional
    public CourseDto create(CourseDto dto) {
        Course course = Course.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        return toDto(courseRepository.save(course));
    }

    @Transactional(readOnly = true)
    public CourseDto get(Long id) {
        return courseRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }

    @Transactional
    public CourseDto update(Long id, CourseDto dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        course.setCode(dto.getCode());
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        return toDto(course);
    }

    @Transactional
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    private CourseDto toDto(Course c) {
        CourseDto dto = new CourseDto();
        dto.setId(c.getId());
        dto.setCode(c.getCode());
        dto.setName(c.getName());
        dto.setDescription(c.getDescription());
        return dto;
    }
}
