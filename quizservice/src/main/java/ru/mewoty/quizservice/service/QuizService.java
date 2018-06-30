package ru.mewoty.quizservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mewoty.quizservice.dao.QuizRepository;
import ru.mewoty.quizservice.exception.NoSuchQuizException;
import ru.mewoty.quizservice.quiz.Quiz;

@Service
public class QuizService {

    @Autowired
    private QuizRepository repository;

    public Long saveNew(Quiz quiz){
        Quiz save = repository.save(quiz);
        return save.getId();
    }

    public Long count(){
        return repository.count();
    }

    public String getDescription(Long id) throws NoSuchQuizException {
        Quiz one = repository.getOne(id);
        if (one == null){
            throw new NoSuchQuizException();
        }
        return one.getDescription();
    }

}
