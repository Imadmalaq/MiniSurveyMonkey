package com.group23.model;

import jakarta.persistence.*;

/**
 * Represents a question asking for a number within a specified range.
 */
@Entity
public class NumericRangeQuestion extends Question {

    /**
     * Minimum acceptable value.
     */
    private int minValue;

    /**
     * Maximum acceptable value.
     */
    private int maxValue;

    // Getters and setters
}
