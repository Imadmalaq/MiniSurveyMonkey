package com.group23.repository;

import com.group23.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Question} entities.
 * Supports inheritance for different question types.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Additional query methods can be defined here if needed.
}
