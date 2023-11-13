package com.mer.onlinediary.dto;

import lombok.Data;

@Data
public class StudentWithAvgGradeDTO {
    private String firstName;
    private String lastName;
    private Double avgGrade;

    public StudentWithAvgGradeDTO(String firstName, String lastName, Double avgGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avgGrade = avgGrade;
    }
}
