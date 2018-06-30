package ru.mewoty.quizservice.quiz.question;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.mewoty.quizservice.quiz.Quiz;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = VariantQuestion.class, name = "variant_question")
})
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String description;

    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    private final QuestionType type;


    protected Question() {
        this.type = getType();
    }

    protected abstract QuestionType getType();


}
