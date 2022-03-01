package com.solenov.quiz.services;

import com.solenov.quiz.entity.Quiz;
import com.solenov.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;


    public Quiz save(Quiz survey) {
        return quizRepository.save(survey);
    }


    public Quiz updateQuizName(Quiz quiz) throws Exception {
        return update(quiz, (currentQuiz) -> currentQuiz.setName(quiz.getName()));
    }


    public Quiz updateSurveyDescription(Quiz quiz) throws Exception {
        return update(quiz, (currentQuiz) -> currentQuiz.setDescription(quiz.getDescription()));
    }

    public Quiz updateQuizQuestions(Quiz quiz) throws Exception {
        return update(quiz, (currentQuiz) -> currentQuiz.getQuestions().addAll(quiz.getQuestions()));
    }


    public Collection<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public Quiz findById(Long id) throws Exception {
        return quizRepository.findById(id)
                .orElseThrow(Exception::new);
    }


    public void deleteSurvey(Long id) {
        quizRepository.deleteById(id);
    }

    private Quiz update(Quiz quiz, Consumer<Quiz> consumer) throws Exception {
        Quiz currentSurvey = quizRepository.findById(quiz.getId())
                .orElseThrow(Exception::new);
        consumer.accept(currentSurvey);
        return quizRepository.save(currentSurvey);
    }
}
