package com.group23.model;

import jakarta.persistence.*;

/**
 * Represents an option in a multiple-choice question.
 */
@Entity
public class Option {

    /**
     * Unique identifier for the option.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The option text.
     */
    private String text;

    /**
     * The question this option belongs to.
     */
    @ManyToOne
    @JoinColumn(name = "question_id")
    private MultipleChoiceQuestion question;

    // Getters and setters

    public Long getId() {
        return id;
    }

    // Since 'id' is auto-generated, a setter is usually not needed.

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipleChoiceQuestion getQuestion() {
        return question;
    }

    public void setQuestion(MultipleChoiceQuestion question) {
        this.question = question;
    }
}
