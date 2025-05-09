package com.example.userservice.UserService.controllers;

import com.example.userservice.UserService.entities.User;
import com.example.userservice.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

//    get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        System.out.println("inside controller" + userId);
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

//    get all users
    @GetMapping
    public ResponseEntity<List<User>> getALlUsers() {
        List<User> user = userService.getAllUser();
        return ResponseEntity.ok(user);
    }

}
