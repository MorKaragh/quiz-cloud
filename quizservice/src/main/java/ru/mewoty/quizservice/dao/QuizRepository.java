package ru.mewoty.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mewoty.quizservice.quiz.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
