package com.group23.controller;

import com.group23.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing questions within surveys.
 */
@Controller
@RequestMapping("/surveys/{surveyId}/questions")
public class QuestionController {

    /**
     * Shows the form to add a new question to a survey.
     *
     * @param surveyId the ID of the survey
     * @param model    the model to add attributes to
     * @return the view name to render
     */
    @GetMapping("/new")
    public String showAddQuestionForm(@PathVariable Long surveyId, Model model) {
        // Method implementation goes here
        return "question/create";
    }

    /**
     * Handles the submission of a new question.
     *
     * @param surveyId the ID of the survey
     * @param question the question object populated from the form
     * @return a redirect to the survey details page
     */
    @PostMapping
    public String addQuestion(@PathVariable Long surveyId, @ModelAttribute Question question) {
        // Method implementation goes here
        return "redirect:/surveys/{surveyId}";
    }
}
