package edu.escuelaing.eci.ieti.service;

import edu.escuelaing.eci.ieti.exception.UserPersistenceException;
import edu.escuelaing.eci.ieti.repository.User;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    User save(User user) throws UserPersistenceException;

    Optional<User> findById(String id) throws UserPersistenceException;

    List<User> all();

    void deleteById(String id) throws UserPersistenceException;

    User update(User user, String userId) throws UserPersistenceException;
}