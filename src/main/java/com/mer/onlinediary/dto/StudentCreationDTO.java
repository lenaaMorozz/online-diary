package com.mer.onlinediary.dto;

import com.mer.onlinediary.entity.Group;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StudentCreationDTO {
    private String firstName;
    private String lastName;
    private int age;
    private int group;
}
