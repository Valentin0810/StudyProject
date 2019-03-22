package com.varvashevich.entity;

import java.time.LocalDateTime;

public class Comment {

    Integer id;
    String message;
    Article post;
    User author;
    LocalDateTime createdAt;
}