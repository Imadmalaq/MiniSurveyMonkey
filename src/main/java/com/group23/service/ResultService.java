package com.group23.service;

import com.group23.model.*;
import com.group23.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service class for generating and retrieving survey results.
 */
@Service
public class ResultService {

    private final ResponseRepository responseRepository;

    /**
     * Constructs a new ResultService with the given repositories.
     *
     * @param responseRepository the repository for responses
     */
    @Autowired
    public ResultService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    /**
     * Generates survey results for a closed survey.
     *
     * @param survey the survey to generate results for
     * @return the survey results
     */
    public SurveyResult generateSurveyResult(Survey survey) {
        List<Response> responses = responseRepository.findBySurvey(survey);

        SurveyResult surveyResult = new SurveyResult();
        surveyResult.setSurvey(survey);

        Map<Question, List<String>> openEndedResults = new HashMap<>();
        Map<Question, Map<Integer, Integer>> numericResults = new HashMap<>();
        Map<Question, Map<Option, Integer>> choiceResults = new HashMap<>();

        for (Response response : responses) {
            for (Answer answer : response.getAnswers()) {
                Question question = answer.getQuestion();

                if (question instanceof OpenEndedQuestion) {
                    openEndedResults.computeIfAbsent(question, k -> new ArrayList<>())
                            .add(answer.getAnswerText());
                } else if (question instanceof NumericRangeQuestion) {
                    int value = Integer.parseInt(answer.getAnswerText());
                    numericResults.computeIfAbsent(question, k -> new HashMap<>())
                            .merge(value, 1, Integer::sum);
                } else if (question instanceof MultipleChoiceQuestion) {
                    Option selectedOption = null;
                    Long optionId = Long.parseLong(answer.getAnswerText());
                    for (Option option : ((MultipleChoiceQuestion) question).getOptions()) {
                        if (option.getId().equals(optionId)) {
                            selectedOption = option;
                            break;
                        }
                    }
                    if (selectedOption != null) {
                        choiceResults.computeIfAbsent(question, k -> new HashMap<>())
                                .merge(selectedOption, 1, Integer::sum);
                    }
                }
            }
        }

        surveyResult.setOpenEndedResults(openEndedResults);
        surveyResult.setNumericResults(numericResults);
        surveyResult.setChoiceResults(choiceResults);

        return surveyResult;
    }
}
