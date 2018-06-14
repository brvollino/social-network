package com.vollino.socialnetwork.service;

import com.vollino.socialnetwork.model.User;
import com.vollino.socialnetwork.repository.UserRepository;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Bruno Vollino
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticationServiceIT {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.save(new User("username", "name", "email", "password"));
    }

    @After
    public void tearDown() {
        userRepository.delete("username");
    }

    @Test
    public void shouldAuthenticateRegisteredUser() {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                "username", "password", null);

        Authentication authenticated = authenticationService.authenticate(authentication);

        assertThat(authenticated, Matchers.notNullValue());
        assertThat(((User) authenticated.getPrincipal()).getUsername(), is("username"));
        assertThat(authenticated.getCredentials(), is("password"));
    }

    @Test(expected = BadCredentialsException.class)
    public void shouldNotAuthenticateUnregisteredUser() {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                "invalidUser", "password", null);

        authenticationService.authenticate(authentication);
    }
}
