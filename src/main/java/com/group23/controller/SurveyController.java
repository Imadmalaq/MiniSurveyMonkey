package com.group23.controller;

import com.group23.model.Survey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing surveys.
 */
@Controller
@RequestMapping("/surveys")
public class SurveyController {

    /**
     * Displays a list of all surveys.
     *
     * @param model the model to add attributes to
     * @return the view name to render
     */
    @GetMapping
    public String listSurveys(Model model) {
        // Method implementation goes here
        return "survey/list";
    }

    /**
     * Shows the form to create a new survey.
     *
     * @param model the model to add attributes to
     * @return the view name to render
     */
    @GetMapping("/new")
    public String showCreateSurveyForm(Model model) {
        // Method implementation goes here
        return "survey/create";
    }

    /**
     * Handles the submission of a new survey.
     *
     * @param survey the survey object populated from the form
     * @return a redirect to the survey list page
     */
    @PostMapping
    public String createSurvey(@ModelAttribute Survey survey) {
        // Method implementation goes here
        return "redirect:/surveys";
    }

    /**
     * Displays the details of a specific survey.
     *
     * @param id    the ID of the survey
     * @param model the model to add attributes to
     * @return the view name to render
     */
    @GetMapping("/{id}")
    public String viewSurvey(@PathVariable Long id, Model model) {
        // Method implementation goes here
        return "survey/view";
    }

    /**
     * Closes a survey, preventing further responses.
     *
     * @param id the ID of the survey to close
     * @return a redirect to the survey details page
     */
    @PostMapping("/{id}/close")
    public String closeSurvey(@PathVariable Long id) {
        // Method implementation goes here
        return "redirect:/surveys/{id}";
    }
}
