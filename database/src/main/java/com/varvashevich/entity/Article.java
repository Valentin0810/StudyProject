package com.varvashevich.entity;

import com.varvashevich.entity.enumonly.Status;
import java.time.LocalDateTime;

public class Article {

    Integer id;
    String title;
    String text;
    Status status;
    User author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}