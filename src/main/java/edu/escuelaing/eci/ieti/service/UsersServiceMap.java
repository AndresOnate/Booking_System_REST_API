package edu.escuelaing.eci.ieti.service;

import edu.escuelaing.eci.ieti.exception.UserPersistenceException;
import edu.escuelaing.eci.ieti.repository.User;
import org.springframework.stereotype.Service;

import java.util.*;


public class UsersServiceMap implements UsersService {

    HashMap<String, User> users = new HashMap<String, User>();

    @Override
    public User save(User user) throws UserPersistenceException {
        if(users.containsKey(user.getId())){
            throw new UserPersistenceException("User already exists" + user);
        }else{
            users.put(user.getId(), user);
            return user;
        }
    }

    @Override
    public Optional<User> findById(String id) throws UserPersistenceException {
        User user = users.get(id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> all() {
        List<User> usersCall = new ArrayList<>();
        usersCall.addAll(users.values());
        return usersCall;
    }

    @Override
    public void deleteById(String id) throws UserPersistenceException{
        if(!users.containsKey(id)){
            throw new UserPersistenceException("User not exists" + id);
        }else{
            users.remove(id);
        }

    }

    @Override
    public User update(User user, String userId) throws UserPersistenceException {
        if(!users.containsKey(userId)) {
            throw new UserPersistenceException("User not exists" + user);
        }else {
            users.put(userId, user);
            return user;
        }
    }
}