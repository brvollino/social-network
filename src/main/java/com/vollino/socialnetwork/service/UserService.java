package com.vollino.socialnetwork.service;

import com.vollino.socialnetwork.model.User;
import com.vollino.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User vote) {
        return userRepository.save(vote);
    }
}
