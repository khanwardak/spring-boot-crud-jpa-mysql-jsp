package com.practiceAPI4.practice4RestAPI.jpa.repository;

import com.practiceAPI4.practice4RestAPI.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
