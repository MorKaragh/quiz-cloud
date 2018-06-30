package ru.mewoty.quizservice.quiz;

import lombok.Data;
import lombok.ToString;
import ru.mewoty.quizservice.quiz.question.Question;
import ru.mewoty.quizservice.quiz.question.Variant;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Question> questions;

    private void answer(Question question, Variant variant){

    }

}
