package com.solenov.quiz.controllers;

import com.solenov.quiz.entity.UserAnswer;
import com.solenov.quiz.services.UserAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/user/answer")
@RequiredArgsConstructor
public class UserAnswerController {
    private final UserAnswerService userAnswerService;

    @PostMapping("/create")
    public UserAnswer create(@RequestBody UserAnswer userAnswer) {
        return userAnswerService.save(userAnswer);
    }

    @GetMapping("/findById/{userId}")
    public Collection<UserAnswer> getAll(@PathVariable String userId) {
        return userAnswerService.findAllAnswersByUserId(userId);
    }
}
