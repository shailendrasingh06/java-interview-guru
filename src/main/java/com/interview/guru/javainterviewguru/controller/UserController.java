package com.interview.guru.javainterviewguru.controller;

import com.interview.guru.javainterviewguru.exception.UserNotFoundException;
import com.interview.guru.javainterviewguru.model.User;
import com.interview.guru.javainterviewguru.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    public UserController(UserRepository userRepository, RestTemplate template ) {
        this.userRepository = userRepository;
        this.restTemplate = template;
    }


    @GetMapping("/")
    public List<User> retrieveUsers() {

        return userRepository.findAll();
    }

    /*Using HATEOS to provide extra details to the user*/

//    @GetMapping("/getUser/{userId}")
//    @Transactional
//    public EntityModel<User> getUser(@PathVariable("userId") Integer userId) {
//
//        Optional<User> fetchedUser = userRepository.findById(userId);
//
//        if(fetchedUser.isEmpty())
//            throw new UserNotFoundException("User with ID: " + userId + " is not present");
//
//        EntityModel<User> userEntityModel = EntityModel.of(fetchedUser.get());
//
//        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveUsers());
//
//        userEntityModel.add(link.withRel("all-users"));
//
//        return userEntityModel;
//    }


    @GetMapping("/getUser/{userId}")
    @Transactional
    public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId) {

        Optional<User> fetchedUser = userRepository.findById(userId);

        if(fetchedUser.isEmpty())
            throw new UserNotFoundException("User with ID: " + userId + " is not present");


        return new ResponseEntity<User>(fetchedUser.get(), HttpStatus.FOUND);
    }

    @GetMapping("getPerson/{id}")
    public String getPerson(@PathVariable("id") String id) {
       ResponseEntity<String> response = this.restTemplate.getForEntity("https://apex.oracle.com/pls/apex/shailendrasoracleworkspace/person/" + id
               , String.class);

       if(response.getStatusCode().is2xxSuccessful()) {
           String responseBody = response.getBody();
           System.out.println(responseBody);
           return responseBody;
       }

       return "No data found";

    }

}
