package com.todolist.users.services;

import com.todolist.users.models.User;
import com.todolist.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> all() {
        return (List<User>) userRepository.findAll();
    }

    public User store(User user) {
        return userRepository.save(user);
    }

    public User edit(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);

        if( userOptional.isEmpty() ) {
            throw new RuntimeException("User was not found");
        }

        User userUpdated = userOptional.get();
        userUpdated.setName(user.getName());
        userUpdated.setEmail(user.getEmail());
        userUpdated.setPassword(user.getPassword());

        return userRepository.save(userUpdated);
    }

    public void delete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if( userOptional.isEmpty() ) {
            throw new RuntimeException("User was not found");
        }

        userRepository.delete(userOptional.get());
    }




}
