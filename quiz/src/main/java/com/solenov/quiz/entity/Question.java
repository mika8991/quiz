package com.solenov.quiz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuizType type;
}
