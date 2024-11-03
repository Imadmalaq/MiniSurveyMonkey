package com.group23.model;

import jakarta.persistence.*;

/**
 * Represents an answer to a specific question in a survey.
 */
@Entity
public class Answer {

    /**
     * Unique identifier for the answer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The question being answered.
     */
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    /**
     * The response this answer belongs to.
     */
    @ManyToOne
    @JoinColumn(name = "response_id")
    private Response response;

    /**
     * The text of the answer (could be text, number, or option ID).
     */
    private String answerText;

    // Getters and setters

    public Long getId() {
        return id;
    }

    // No setter for 'id' as it's auto-generated.

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
