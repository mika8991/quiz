package com.solenov.quiz.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_answer")
@Data
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String survey;
    private String question;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();
}
