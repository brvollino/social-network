package com.vollino.socialnetwork.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.vollino.socialnetwork.model.Post;
import com.vollino.socialnetwork.model.User;
import com.vollino.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {

    //TODO: Implementar
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        Date now = new Date();
        List<Post> timelineMock = Lists.newArrayList(
                new Post(1L, new User("username1", "User 1",
                "password", "email@email.com"), now, "Post text 1"),
                new Post(2L, new User("username2", "User 2",
                        "password", "email@email.com"), new Date(now.getTime()-100000), "Post text 2"));

        return new ModelAndView("index", ImmutableMap.of("posts", timelineMock), HttpStatus.OK);
    }
}
