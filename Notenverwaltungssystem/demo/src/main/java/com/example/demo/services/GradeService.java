package com.example.demo.services;

import com.example.demo.dto.GradeDTO;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.entity_repository.GradeRepository;
import com.example.demo.entity_repository.StudentRepository;
import com.example.demo.entity_repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository,
            SubjectRepository subjectRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public Grade addGrade(GradeDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setSubject(subject);
        grade.setGrade(dto.getGrade());
        grade.setGradedAt(LocalDateTime.now());
        return gradeRepository.save(grade);
    }

    public List<Grade> getGradesForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return gradeRepository.findByStudent(student);
    }
}
