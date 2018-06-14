package com.vollino.socialnetwork.repository;

import com.vollino.socialnetwork.model.Post;
import com.vollino.socialnetwork.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByOrderByCreationDateDesc();
}
