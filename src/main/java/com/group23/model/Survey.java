package com.group23.model;

import java.util.List;

/**
 * Represents a survey created by the surveyor.
 */
public class Survey {

    /**
     * Unique identifier for the survey.
     */
    private Long id;

    /**
     * Title of the survey.
     */
    private String title;

    /**
     * Description of the survey.
     */
    private String description;

    /**
     * List of questions in the survey.
     */
    private List<Question> questions;

    /**
     * Indicates whether the survey is open for responses.
     */
    private boolean isOpen;

    // Getters and setters to be added later.
}
