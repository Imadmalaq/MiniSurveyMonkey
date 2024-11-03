package com.group23.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a survey created by the surveyor.
 */
@Entity
public class Survey {

    /**
     * Unique identifier for the survey.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<Question> questions;

    /**
     * Indicates whether the survey is open for responses.
     */
    private boolean isOpen;

    // Getters and setters

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    // Other getters and setters can be added here
}
