package com.interview.guru.javainterviewguru;

import com.interview.guru.javainterviewguru.controller.UserController;
import com.interview.guru.javainterviewguru.model.User;
import com.interview.guru.javainterviewguru.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    public void testGetUser() {
        int userId = 1;
//        User expectedUser = new User(userId, "Alice Smith", "alice@example.com");
        User expectedUser = new User(2, "Alice", "alice@example.com");
        when(userRepository.findById(userId)).thenReturn(Optional.of(expectedUser));

        User actualUser = userController.getUser(userId);

        System.out.println("Actual User: " + actualUser.getName());

        assertEquals(expectedUser, actualUser);

        verify(userRepository).findById(userId);
    }


}
