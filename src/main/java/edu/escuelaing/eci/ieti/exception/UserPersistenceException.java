package edu.escuelaing.eci.ieti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserPersistenceException extends ResponseStatusException {

    public UserPersistenceException(String id) {
        super(HttpStatus.BAD_REQUEST, "user with ID: " + id);
    }
}
