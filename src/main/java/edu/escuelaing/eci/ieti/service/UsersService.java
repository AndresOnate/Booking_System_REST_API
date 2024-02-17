package edu.escuelaing.eci.ieti.service;

import edu.escuelaing.eci.ieti.exception.UserPersistenceException;
import edu.escuelaing.eci.ieti.repository.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public interface UsersService {

    HashMap<String, User> users = new HashMap<String, User>();

    User save(User user) throws UserPersistenceException;

    Optional<User> findById(String id) throws UserPersistenceException;

    List<User> all();

    void deleteById(String id) throws UserPersistenceException;

    User update(User user, String userId) throws UserPersistenceException;
}
