package com.mikeyy.studentmanagementsystem.controller;


import com.mikeyy.studentmanagementsystem.dto.CourseDto;
import com.mikeyy.studentmanagementsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public Page<CourseDto> list(Pageable pageable) {
        return courseService.list(pageable);
    }

    @PostMapping
    public CourseDto create(@RequestBody CourseDto dto) {
        return courseService.create(dto);
    }

    @GetMapping("/{id}")
    public CourseDto get(@PathVariable Long id) {
        return courseService.get(id);
    }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable Long id, @RequestBody CourseDto dto) {
        return courseService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
