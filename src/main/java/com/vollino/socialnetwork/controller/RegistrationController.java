package com.vollino.socialnetwork.controller;

import com.vollino.socialnetwork.model.User;
import com.vollino.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void register(@ModelAttribute("user") User user) {
        userService.save(user);
    }
}
