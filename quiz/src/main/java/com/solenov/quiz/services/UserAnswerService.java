package com.solenov.quiz.services;

import com.solenov.quiz.entity.UserAnswer;
import com.solenov.quiz.repository.UserAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserAnswerService {
    private final UserAnswerRepository userAnswerRepository;

    public UserAnswer save(UserAnswer userAnswer) {
        return userAnswerRepository.save(userAnswer);
    }

    public Collection<UserAnswer> findAllAnswersByUserId(String userId) {
        return userAnswerRepository.findByUserId(userId);
    }
}
