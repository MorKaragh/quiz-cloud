package ru.mewoty.quizservice.quiz.question;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "variant_questions")
public class VariantQuestion extends Question {

    @OneToMany(mappedBy = "question", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Variant> variants;

    @Override
    protected QuestionType getType() {
        return QuestionType.VARIANT;
    }
}
