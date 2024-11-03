package com.group23.model;

import jakarta.persistence.*;

/**
 * Abstract base class representing a question in a survey.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "question_type")
public abstract class Question {

    /**
     * Unique identifier for the question.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The question text.
     */
    private String text;

    /**
     * The survey this question belongs to.
     */
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    // Getters and setters
}
