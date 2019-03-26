package com.varvashevich.repository;

import com.varvashevich.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoty extends CrudRepository<User, Long> {
}
