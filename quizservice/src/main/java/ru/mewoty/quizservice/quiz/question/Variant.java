package ru.mewoty.quizservice.quiz.question;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "variants")
@Data
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name = "question_id")
    private VariantQuestion question;
    private String description;
}
