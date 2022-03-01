package com.solenov.quiz.controllers;

import com.solenov.quiz.entity.Question;
import com.solenov.quiz.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add/{quizId}")
    public Question create(@RequestBody Question question, @PathVariable Long quizId) throws Exception {
        return questionService.create(question, quizId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/text")
    public Question updateText(@RequestBody Question question) throws Exception {
        return questionService.updateTextQuestion(question);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/type")
    public Question updateType(@RequestBody Question question) throws Exception {
        return questionService.updateTypeQuestion(question);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{quizId}/{questionId}")
    public String deleteQuestion(@PathVariable Long quizId, @PathVariable Long questionId) throws Exception {
        questionService.delete(quizId, questionId);
        return String.format("Вопрос с ID: %d был удалён", questionId);
    }
}
