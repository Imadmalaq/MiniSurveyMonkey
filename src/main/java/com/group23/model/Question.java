package com.group23.model;

/**
 * Abstract base class representing a question in a survey.
 */
public abstract class Question {

    /**
     * Unique identifier for the question.
     */
    private Long id;

    /**
     * The question text.
     */
    private String text;

    /**
     * The survey this question belongs to.
     */
    private Survey survey;

    // Getters and setters to be added later.
}
