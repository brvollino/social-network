package com.vollino.socialnetwork.controller;

import com.vollino.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public String createPost(String text) {
        postService.save(text);

        return "redirect:/";
    }
}
