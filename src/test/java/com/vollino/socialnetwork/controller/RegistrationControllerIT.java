package com.vollino.socialnetwork.controller;

import com.vollino.socialnetwork.model.User;
import com.vollino.socialnetwork.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Bruno Vollino
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrationControllerIT {

    @Autowired
    private RegistrationController registrationController;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldCreateUserAccount() {
        User expectedUser = new User("username", "name", "email", "password");

        registrationController.register(expectedUser);
        User actualUser = userRepository.findOne("username");

        assertThat(expectedUser, equalTo(actualUser));
    }
}