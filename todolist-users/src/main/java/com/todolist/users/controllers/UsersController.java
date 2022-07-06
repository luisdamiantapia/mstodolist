package com.todolist.users.controllers;

import com.todolist.users.models.User;
import com.todolist.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> all() {
        return userService.all();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body( userService.store(user) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit( @RequestBody User user, @PathVariable Long id ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.edit(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
