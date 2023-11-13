package com.mer.onlinediary.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StudentCreationDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Min(5)
    @Max(19)
    private int age;
    @Min(1)
    @Max(12)
    private int group;
}
