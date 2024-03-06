package edu.escuelaing.eci.ieti.service;

import edu.escuelaing.eci.ieti.exception.UserNotFoundException;
import edu.escuelaing.eci.ieti.exception.UserPersistenceException;
import edu.escuelaing.eci.ieti.repository.user.User;
import edu.escuelaing.eci.ieti.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDb implements UserService {

    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UserServiceMongoDb(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public User save(User user) {
        return userMongoRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        if (userMongoRepository.existsById(id)) {
            return userMongoRepository.findById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public User findByEmail(String email) throws UserPersistenceException {
        Optional<User> optionalUser = userMongoRepository.findByEmail(email);
        if ( optionalUser.isPresent() ){
            return optionalUser.get();
        } else {
            throw new UserNotFoundException("");
        }
    }

    @Override
    public List<User> all() {
        List<User> users = userMongoRepository.findAll();
        return users;
    }

    @Override
    public void deleteById(String id) {
        if (userMongoRepository.existsById(id)) {
            userMongoRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public User update(User user, String userId) {
        if(userMongoRepository.findById(userId).isPresent()){
            return userMongoRepository.save(user);
        }
        return null;
    }
}
