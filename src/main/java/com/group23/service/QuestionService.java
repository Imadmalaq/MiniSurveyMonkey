package com.group23.service;

import com.group23.model.Question;
import com.group23.model.Survey;
import com.group23.repository.QuestionRepository;
import com.group23.repository.SurveyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Service class for handling question operations.
 */
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;

    /**
     * Constructs a new QuestionService with the given repositories.
     *
     * @param questionRepository the repository for questions
     * @param surveyRepository   the repository for surveys
     */
    @Autowired
    public QuestionService(QuestionRepository questionRepository, SurveyRepository surveyRepository) {
        this.questionRepository = questionRepository;
        this.surveyRepository = surveyRepository;
    }

    /**
     * Adds a question to a survey.
     *
     * @param surveyId the ID of the survey
     * @param question the question to add
     * @return the added question
     */
    public Question addQuestionToSurvey(Long surveyId, Question question) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new EntityNotFoundException("Survey not found with id " + surveyId));
        if (!survey.getIsOpen()) {
            throw new IllegalStateException("Survey is closed for new questions.");
        }
        survey.addQuestion(question);
        surveyRepository.save(survey);
        return question;
    }



    /**
     * Retrieves a question by its ID.
     *
     * @param id the ID of the question
     * @return the question, or null if not found
     */
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing question.
     *
     * @param question the question to update
     * @return the updated question
     */
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    /**
     * Deletes a question by its ID.
     *
     * @param id the ID of the question to delete
     */
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    /**
     * Lists all questions for a survey.
     *
     * @param surveyId the ID of the survey
     * @return a list of questions for the survey
     */
    public List<Question> listQuestionsBySurvey(Long surveyId) {
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        if (survey != null) {
            return survey.getQuestions();
        }
        return null;
    }
}
