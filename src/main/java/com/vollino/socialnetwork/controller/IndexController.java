package com.vollino.socialnetwork.controller;

import com.google.common.collect.ImmutableMap;
import com.vollino.socialnetwork.model.Post;
import com.vollino.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    private final PostService postService;

    @Autowired
    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        List<Post> timeline = postService.findAllByOrderByCreationDateDesc();

        return new ModelAndView("index", ImmutableMap.of("posts", timeline), HttpStatus.OK);
    }
}
