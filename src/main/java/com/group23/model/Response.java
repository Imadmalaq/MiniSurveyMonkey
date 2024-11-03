package com.group23.model;

import jakarta.persistence.*;
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
    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL)
    private List<Answer> answers;

    // Getters and setters
}
