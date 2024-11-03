package com.group23.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user's response to a survey.
 */
@Entity
public class Response {

    /**
     * Unique identifier for the response.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The survey being responded to.
     */
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    /**
     * List of answers provided by the user.
     */
    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    // Getters and setters

    public Long getId() {
        return id;
    }

    // Since 'id' is auto-generated, a setter for it is usually not needed.

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    // Optional: Convenience methods to manage the bidirectional relationship

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setResponse(this);
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
        answer.setResponse(null);
    }
}
