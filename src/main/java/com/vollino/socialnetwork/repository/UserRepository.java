package com.vollino.socialnetwork.repository;

import com.vollino.socialnetwork.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
