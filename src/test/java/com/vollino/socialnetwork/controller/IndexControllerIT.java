package com.vollino.socialnetwork.controller;

import com.google.common.collect.Lists;
import com.vollino.socialnetwork.model.Post;
import com.vollino.socialnetwork.model.User;
import com.vollino.socialnetwork.repository.PostRepository;
import com.vollino.socialnetwork.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Bruno Vollino
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerIT {

    @Autowired
    private IndexController indexController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void shouldDisplayAllPostsSortedAscendingByCreation() {
        User user = new User("username", "name", "email", "password");
        Timestamp now = new Timestamp(new Date().getTime());
        Post expectedPost1 = new Post(null, user, now, "text1");
        Post expectedPost2 = new Post(null, user, new Timestamp(now.getTime()+1000), "text2");

        userRepository.save(user);
        expectedPost2 = postRepository.save(expectedPost2);
        expectedPost1 = postRepository.save(expectedPost1);

        ModelAndView modelAndView = indexController.index();
        List<Post> actualPosts = (List<Post>) modelAndView.getModel().get("posts");

        assertThat(actualPosts, equalTo(Lists.newArrayList(expectedPost2, expectedPost1)));
    }
}