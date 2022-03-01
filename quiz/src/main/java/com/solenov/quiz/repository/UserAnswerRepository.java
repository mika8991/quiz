package com.solenov.quiz.repository;

import com.solenov.quiz.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    Collection<UserAnswer> findByUserId(String userId);
}
