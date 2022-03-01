package com.solenov.quiz.services;

import com.solenov.quiz.entity.Question;
import com.solenov.quiz.entity.Quiz;
import com.solenov.quiz.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepo;
    private final QuizService quizService;

    public Question create(Question question, Long quizId) throws Exception {
        Quiz currentQuiz = quizService.findById(quizId);
        currentQuiz.getQuestions().add(question);
        quizService.updateQuizQuestions(currentQuiz);
        return questionRepo.save(question);
    }


    public Question updateTextQuestion(Question question) throws Exception {
        return update(question, (currentQuestion) -> currentQuestion.setText(question.getText()));
    }


    public Question updateTypeQuestion(Question question) throws Exception {
        return update(question, (currentQuestion) -> currentQuestion.setType(question.getType()));
    }


    public void delete(Long surveyId, Long questionId) throws Exception {
        Quiz updateQuiz = quizService.findById(surveyId);
        Question deleteQuestion = updateQuiz.getQuestions().stream()
                .filter(question -> Objects.equals(question.getId(), questionId))
                .findFirst()
                .orElseThrow(Exception::new);
        updateQuiz.getQuestions().remove(deleteQuestion);
        quizService.save(updateQuiz);
    }

    private Question update(Question question, Consumer<Question> consumer) throws Exception {
        Question currentQuestion = questionRepo.findById(question.getId())
                .orElseThrow(Exception::new);
        consumer.accept(currentQuestion);
        return questionRepo.save(currentQuestion);
    }
}
