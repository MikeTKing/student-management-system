# Student Management System (Spring Boot + PostgreSQL)

A RESTful **Student Management System** built with Spring Boot, Spring Data JPA, Spring Security, and PostgreSQL.  
It manages students, courses, and enrollments, with pagination, search, basic reporting, and Swagger API documentation.

## Tech Stack

- Java 21+
- Spring Boot 4.x (Web, Data JPA, Security, Validation)
- PostgreSQL
- Hibernate / JPA
- Lombok
- springdoc-openapi (Swagger UI)

## Features

- CRUD operations for students, courses, and enrollments
- Many-to-many relationship via an `Enrollment` join entity (student–course)
- Pagination and search (by student name/email)
- Basic grade reporting (average grade per course)
- Role-based access control with Spring Security (teacher/admin)
- API documentation with Swagger UI

## Architecture

- **Entities**: `Student`, `Course`, `Enrollment`
- **DTOs**: `StudentDto`, `CourseDto`, `EnrollmentDto`, `GradeReportDto`
- **Layers**:
  - `controller` – REST endpoints
  - `service` – business logic with `@Transactional`
  - `repository` – Spring Data JPA repositories

## Project Structure
```text
src/
  main/
    java/com/example/sms/
      config/
        OpenApiConfig.java
      security/
        SecurityConfig.java
        Role.java
      controller/
        StudentController.java
        CourseController.java
        EnrollmentController.java
      dto/
        StudentDto.java
        CourseDto.java
        EnrollmentDto.java
        GradeReportDto.java
      entity/
        Student.java
        Course.java
        Enrollment.java
      repository/
        StudentRepository.java
        CourseRepository.java
        EnrollmentRepository.java
      service/
        StudentService.java
        CourseService.java
        EnrollmentService.java
      StudentManagementSystemApplication.java
    resources/
      application.yml
      data.sql
