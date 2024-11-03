package com.group23.repository;

import com.group23.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Response} entities.
 */
public interface ResponseRepository extends JpaRepository<Response, Long> {
    // Additional query methods can be defined here if needed.
}
