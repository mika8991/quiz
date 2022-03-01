package com.solenov.quiz.controllers;

import com.solenov.quiz.entity.Quiz;
import com.solenov.quiz.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Quiz addNEwSurvey(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    @GetMapping("/quizzes")
    public Collection<Quiz> getAll() {
        return quizService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/name")
    public Quiz updateName(@RequestBody Quiz quiz) throws Exception {
        return quizService.updateQuizName(quiz);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/description")
    public Quiz updateDescription(@RequestBody Quiz quiz) throws Exception {
        return quizService.updateSurveyDescription(quiz);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/questions")
    public Quiz updateQuestions(@RequestBody Quiz quiz) throws Exception {
        return quizService.updateQuizQuestions(quiz);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizService.deleteSurvey(id);
        return String.format("Опрос с ID: %d был удалён", id);
    }
}
