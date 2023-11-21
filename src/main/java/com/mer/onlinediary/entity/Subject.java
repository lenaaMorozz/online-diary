package com.mer.onlinediary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "student", name = "subject")
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
