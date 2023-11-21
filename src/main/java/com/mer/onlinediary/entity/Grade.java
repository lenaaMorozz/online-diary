package com.mer.onlinediary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "student", name = "grade")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    private int grade;
}
