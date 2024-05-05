package com.interview.guru.javainterviewguru.controller;

import com.interview.guru.javainterviewguru.model.User;
import com.interview.guru.javainterviewguru.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {

        Optional<User> fetchedUser = userRepository.findById(userId);

        return fetchedUser.orElseThrow();

    }
}
