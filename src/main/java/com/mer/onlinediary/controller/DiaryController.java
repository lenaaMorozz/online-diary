package com.mer.onlinediary.controller;

import com.mer.onlinediary.dto.GradeModificationDTO;
import com.mer.onlinediary.dto.StudentCreationDTO;
import com.mer.onlinediary.dto.StudentWithAvgGradeDTO;
import com.mer.onlinediary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService service;

    @GetMapping("/groups/{groupId}/grades/avg")
    public ResponseEntity<List<StudentWithAvgGradeDTO>> getAvgGradesByGroup(@PathVariable int groupId) {
        List<StudentWithAvgGradeDTO> students = service.getAvgGradesByGroup(groupId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/groups/students/{studentId}/grades/{subjectName}/{newGrade}")
    public ResponseEntity<String> updateGradeForSubjectByStudentId(@PathVariable int studentId,
                                                                   @PathVariable String subjectName,
                                                                   @PathVariable int newGrade) {
        service.updateGradeForSubjectByStudentId(GradeModificationDTO.builder()
                        .studentId(studentId)
                        .newGrade(newGrade)
                        .subjectName(subjectName)
                .build());
        return ResponseEntity.ok("Оценка успешно обновлена");
    }

    @PostMapping("/groups/students")
    public ResponseEntity<String> createStudent(@RequestBody StudentCreationDTO dto) {
        service.createStudent(dto);
        return ResponseEntity.ok("Студент успешно добавлен");
    }
}
