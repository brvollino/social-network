package com.vollino.socialnetwork.service;

import com.vollino.socialnetwork.model.Post;
import com.vollino.socialnetwork.model.User;
import com.vollino.socialnetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;
    private AuthenticationService authenticationService;

    @Autowired
    public PostService(PostRepository postRepository, AuthenticationService authenticationService) {
        this.postRepository = postRepository;
        this.authenticationService = authenticationService;
    }

    public List<Post> findAllByOrderByCreationDateDesc() {
        return postRepository.findAllByOrderByCreationDateDesc();
    }

    public Post save(String postText) {
        User loggedUser = authenticationService.loggedUser();
        Post post = new Post(null, loggedUser, new Date(), postText);

        return postRepository.save(post);
    }
}
