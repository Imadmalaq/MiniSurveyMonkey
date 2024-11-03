package com.group23.model;

/**
 * Represents an answer to a specific question in a survey.
 */
public class Answer {

    /**
     * Unique identifier for the answer.
     */
    private Long id;

    /**
     * The question being answered.
     */
    private Question question;

    /**
     * The response this answer belongs to.
     */
    private Response response;

    /**
     * The text of the answer (could be text, number, or option ID).
     */
    private String answerText;

    // Getters and setters to be added later.
}
