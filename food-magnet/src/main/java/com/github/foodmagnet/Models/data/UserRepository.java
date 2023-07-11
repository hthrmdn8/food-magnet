package com.github.foodmagnet.Models.data;

import com.github.foodmagnet.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}