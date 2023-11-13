package com.mer.onlinediary.controller;

import com.mer.onlinediary.dto.GradeModificationDTO;
import com.mer.onlinediary.dto.StudentCreationDTO;
import com.mer.onlinediary.dto.StudentWithAvgGradeDTO;
import com.mer.onlinediary.service.DiaryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService service;

    @GetMapping("/groups/{groupId}/grades/avg")
    public ResponseEntity<List<StudentWithAvgGradeDTO>> getAvgGradesByGroup(@PathVariable @Min(1) @Max(12) int groupId) {
        List<StudentWithAvgGradeDTO> students = service.getAvgGradesByGroup(groupId);
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/groups/students/{studentId}/grades/{subjectName}/{newGrade}")
    public ResponseEntity<String> updateGradeForSubjectByStudentId(@PathVariable @Min(0) int studentId,
                                                                   @PathVariable String subjectName,
                                                                   @PathVariable @Min(2) @Max(5) int newGrade) {
        int quantityModifRow = service.updateGradeForSubjectByStudentId(GradeModificationDTO.builder()
                        .studentId(studentId)
                        .newGrade(newGrade)
                        .subjectName(subjectName)
                .build());
        if (quantityModifRow < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ученик или предмет не найден");
        }
        return ResponseEntity.ok("Оценка успешно обновлена");
    }

    @PostMapping("/groups/students")
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentCreationDTO dto) {
        try {
            service.createStudent(dto);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Класс не найден");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Неверное тело запроса");
        }
        return ResponseEntity.ok("Студент успешно добавлен");
    }
}
