package io.github.yunu7067.hibernatesearchdemo.post.dto;

import io.github.yunu7067.hibernatesearchdemo.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}