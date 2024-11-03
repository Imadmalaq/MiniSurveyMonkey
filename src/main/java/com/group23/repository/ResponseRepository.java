package com.group23.repository;

import com.group23.model.Response;
import com.group23.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for {@link Response} entities.
 */
public interface ResponseRepository extends JpaRepository<Response, Long> {

    /**
     * Finds all responses for a given survey.
     *
     * @param survey the survey
     * @return a list of responses
     */
    List<Response> findBySurvey(Survey survey);
}
