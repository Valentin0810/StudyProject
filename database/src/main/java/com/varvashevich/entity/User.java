package com.varvashevich.entity;

import com.varvashevich.entity.enumonly.Role;
import java.time.LocalDateTime;

public class User {

    Integer id;
    String firstName;
    String lastName;
    Role role;
    String password;
    String email;
    LocalDateTime createdAt;
}