package com.group23.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a question where users choose from multiple options.
 */
@Entity
public class MultipleChoiceQuestion extends Question {

    /**
     * List of available options.
     */
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Option> options;

    // Methods to add or remove options

    // Getters and setters
}
