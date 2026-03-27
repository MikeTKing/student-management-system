package com.mikeyy.studentmanagementsystem.service;



import com.mikeyy.studentmanagementsystem.dto.StudentDto;
import com.mikeyy.studentmanagementsystem.entity.Student;
import com.mikeyy.studentmanagementsystem.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public Page<StudentDto> listStudents(String keyword, Pageable pageable) {
        Page<Student> page;
        if (keyword == null || keyword.isBlank()) {
            page = studentRepository.findAll(pageable);
        } else {
            page = studentRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                            keyword, keyword, pageable);
        }
        return page.map(this::toDto);
    }

    @Transactional
    public StudentDto create(StudentDto dto) {
        Student student = Student.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
        return toDto(studentRepository.save(student));
    }

    @Transactional(readOnly = true)
    public StudentDto get(Long id) {
        return studentRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    @Transactional
    public StudentDto update(Long id, StudentDto dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        return toDto(student);
    }

    @Transactional
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    private StudentDto toDto(Student s) {
        StudentDto dto = new StudentDto();
        dto.setId(s.getId());
        dto.setFirstName(s.getFirstName());
        dto.setLastName(s.getLastName());
        dto.setEmail(s.getEmail());
        return dto;
    }
}