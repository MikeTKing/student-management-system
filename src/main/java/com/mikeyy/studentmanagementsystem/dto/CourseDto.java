package com.mikeyy.studentmanagementsystem.dto;

import lombok.Data;

@Data
public class CourseDto {
    private Long id;
    private String code;
    private String name;
    private String description;
}
