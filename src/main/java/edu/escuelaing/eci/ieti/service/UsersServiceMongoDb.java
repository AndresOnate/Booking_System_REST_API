package edu.escuelaing.eci.ieti.service;

import edu.escuelaing.eci.ieti.repository.User;
import edu.escuelaing.eci.ieti.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceMongoDb implements UsersService {

    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UsersServiceMongoDb(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public User save(User user) {
        return userMongoRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        Optional<User> user = userMongoRepository.findById(id);
        return user;
    }

    @Override
    public List<User> all() {
        List<User> users = userMongoRepository.findAll();
        return users;
    }

    @Override
    public void deleteById(String id) {
        userMongoRepository.deleteById(id);
    }

    @Override
    public User update(User user, String userId) {
        if(userMongoRepository.findById(userId).isPresent()){
            return userMongoRepository.save(user);
        }
        return null;
    }
}
