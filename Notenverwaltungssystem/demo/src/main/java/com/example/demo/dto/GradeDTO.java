package com.example.demo.dto;

public class GradeDTO {
    private Long studentId;
    private Long subjectId;
    private Integer grade;

    // Kein-Argument-Konstruktor
    public GradeDTO() {
    }

    // Konstruktor mit allen Feldern
    public GradeDTO(Long studentId, Long subjectId, Integer grade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.grade = grade;
    }

    // Getter und Setter für 'studentId'
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    // Getter und Setter für 'subjectId'
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    // Getter und Setter für 'grade'
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}