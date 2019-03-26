package com.varvashevich.repository;

import com.varvashevich.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmailIgnoreCase(String email);
}