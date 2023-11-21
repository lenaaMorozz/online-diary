package com.mer.onlinediary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "student", name = "group")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "group_num")
    private int groupNum;
}
