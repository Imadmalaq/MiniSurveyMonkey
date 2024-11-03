package com.group23.model;

import java.util.List;
import java.util.Map;

/**
 * Represents the compiled results of a survey once it has been closed.
 */
public class SurveyResult {

    /**
     * Unique identifier for the survey result.
     */
    private Long id;

    /**
     * The survey the results belong to.
     */
    private Survey survey;

    /**
     * Map of open-ended questions to their answers.
     */
    private Map<Question, List<String>> openEndedResults;

    /**
     * Map of numeric questions to histograms (value to count).
     */
    private Map<Question, Map<Integer, Integer>> numericResults;

    /**
     * Map of multiple-choice questions to option counts.
     */
    private Map<Question, Map<Option, Integer>> choiceResults;

    // Methods to generate and retrieve results to be added later.
}
