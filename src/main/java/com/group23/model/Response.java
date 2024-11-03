package com.group23.model;

import java.util.List;

/**
 * Represents a user's response to a survey.
 */
public class Response {

    /**
     * Unique identifier for the response.
     */
    private Long id;

    /**
     * The survey being responded to.
     */
    private Survey survey;

    /**
     * List of answers provided by the user.
     */
    private List<Answer> answers;

    // Getters and setters to be added later.
}
