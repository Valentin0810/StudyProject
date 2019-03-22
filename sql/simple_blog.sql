CREATE DATABASE simple_blog ENCODING = 'UTF-8';
CREATE SCHEMA simple_blog;

CREATE TABLE simple_blog.tag (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(64) UNIQUE
);

CREATE TABLE simple_blog.comment (
  id         BIGSERIAL PRIMARY KEY,
  message    TEXT,
  article_id BIGSERIAL REFERENCES simple_blog.article (id),
  user_id    BIGSERIAL references simple_blog.user (id),
  created_at DATE
);

CREATE TABLE simple_blog.user (
  id         BIGSERIAL PRIMARY KEY,
  first_name VARCHAR(128),
  last_name  VARCHAR(128),
  password   VARCHAR(32)         NOT NULL,
  email      VARCHAR(128) UNIQUE NOT NULL,
  created_at DATE
);

CREATE TABLE simple_blog.article (
  id         BIGSERIAL PRIMARY KEY,
  title      CHARACTER VARYING(256),
  text       TEXT,
  status     VARCHAR(24),
  user_id    BIGSERIAL REFERENCES simple_blog.user (id),
  created_at DATE,
  updated_at DATE
);

CREATE TABLE simple_blog.tag_article (
  tag_id     BIGSERIAL REFERENCES simple_blog.tag (id),
  article_id BIGSERIAL REFERENCES simple_blog.article (id)
);