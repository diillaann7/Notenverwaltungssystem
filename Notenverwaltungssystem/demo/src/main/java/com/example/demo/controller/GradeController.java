package com.example.demo.controller;

import com.example.demo.dto.GradeDTO;
import com.example.demo.entity.Grade;
import com.example.demo.services.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService service) {
        this.gradeService = service;
    }

    @PostMapping("/addgrade")
    public Grade addGrade(@RequestBody GradeDTO dto) {
        return gradeService.addGrade(dto);
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getGradesForStudent(@PathVariable Long studentId) {
        return gradeService.getGradesForStudent(studentId);
    }


}
