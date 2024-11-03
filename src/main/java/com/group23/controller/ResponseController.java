package com.group23.controller;

import com.group23.model.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling user responses to surveys.
 */
@Controller
@RequestMapping("/surveys/{surveyId}/respond")
public class ResponseController {

    /**
     * Displays the survey form for users to fill out.
     *
     * @param surveyId the ID of the survey
     * @param model    the model to add attributes to
     * @return the view name to render
     */
    @GetMapping
    public String showSurveyForm(@PathVariable Long surveyId, Model model) {
        // Method implementation goes here
        return "response/form";
    }

    /**
     * Handles the submission of a user's survey responses.
     *
     * @param surveyId the ID of the survey
     * @param response the response object populated from the form
     * @return a redirect to a thank-you page
     */
    @PostMapping
    public String submitSurveyResponse(@PathVariable Long surveyId, @ModelAttribute Response response) {
        // Method implementation goes here
        return "redirect:/surveys/{surveyId}/respond/thank-you";
    }

    /**
     * Displays a thank-you page after the survey is submitted.
     *
     * @param surveyId the ID of the survey
     * @return the view name to render
     */
    @GetMapping("/thank-you")
    public String showThankYouPage(@PathVariable Long surveyId) {
        // Method implementation goes here
        return "response/thank-you";
    }
}
