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

INSERT INTO simple_blog.user (first_name, last_name, password, email, created_at) VALUES
  ('Ivanov', 'Ivan', '1111', 'ivanov@gmail.com', '2019-05-01'),
  ('Petrov', 'Petr', '2222', 'petrov@gmail.com', '2019-06-01'),
  ('Sidorov', 'Fedor', '3333', 'sidorov@gmail.com', '2019-07-01');

INSERT INTO simple_blog.tag (name) VALUES
  ('courses'),
  ('leverX'),
  ('students');

