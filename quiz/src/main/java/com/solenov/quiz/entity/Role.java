package com.solenov.quiz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String role;
}
