package com.mer.onlinediary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@Builder
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
