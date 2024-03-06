package edu.escuelaing.eci.ieti.controller;


import edu.escuelaing.eci.ieti.exception.UserPersistenceException;
import edu.escuelaing.eci.ieti.repository.user.User;
import edu.escuelaing.eci.ieti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users/")
public class UserController {

    private final UserService usersService;

    public UserController(@Autowired UserService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            User user = usersService.save(newUser);
            URI createdUserUri = URI.create("/users/" + user.getId());
            return ResponseEntity.created(createdUserUri).body(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new UserPersistenceException(newUser.getId());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.all();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        Optional<User> existingUserOptional = usersService.findById(id);
        User user = existingUserOptional.get();
        return ResponseEntity.ok(user);

    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User newUser) {
        User updatedUser = usersService.update(newUser, id);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        usersService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
