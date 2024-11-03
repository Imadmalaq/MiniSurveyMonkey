package com.group23.service;

import com.group23.model.Answer;
import com.group23.model.Question;
import com.group23.model.Response;
import com.group23.model.Survey;
import com.group23.repository.AnswerRepository;
import com.group23.repository.QuestionRepository;
import com.group23.repository.ResponseRepository;
import com.group23.repository.SurveyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling survey responses.
 */
@Service
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    /**
     * Constructs a new ResponseService with the given repositories.
     *
     * @param responseRepository the repository for responses
     * @param surveyRepository   the repository for surveys
     * @param questionRepository the repository for questions
     * @param answerRepository   the repository for answers
     */
    @Autowired
    public ResponseService(ResponseRepository responseRepository,
                           SurveyRepository surveyRepository,
                           QuestionRepository questionRepository,
                           AnswerRepository answerRepository) {
        this.responseRepository = responseRepository;
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    /**
     * Saves a user's response to a survey.
     *
     * @param surveyId the ID of the survey
     * @param response the response to save
     * @return the saved response
     */
    @Transactional
    public Response saveResponse(Long surveyId, Response response) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new EntityNotFoundException("Survey not found with ID: " + surveyId));

        if (!survey.getIsOpen()) {
            throw new IllegalStateException("Survey is closed for responses.");
        }

        response.setSurvey(survey);

        // Associate each answer with its question and response
        for (Answer answer : response.getAnswers()) {
            Question question = questionRepository.findById(answer.getQuestion().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Question not found with ID: " + answer.getQuestion().getId()));
            answer.setQuestion(question);
            answer.setResponse(response); // Set the response in answer
        }

        // Save the response along with answers (thanks to CascadeType.ALL)
        return responseRepository.save(response);
    }


    /**
     * Retrieves all responses for a survey.
     *
     * @param surveyId the ID of the survey
     * @return a list of responses
     */
    public List<Response> listResponsesBySurvey(Long surveyId) {
        Survey survey = surveyRepository.findById(surveyId).orElse(null);
        if (survey != null) {
            return responseRepository.findBySurvey(survey);
        }
        return null;
    }
}
