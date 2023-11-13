package com.mer.onlinediary.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GradeModificationDTO {
    private int newGrade;
    private int studentId;
    private String subjectName;
}
