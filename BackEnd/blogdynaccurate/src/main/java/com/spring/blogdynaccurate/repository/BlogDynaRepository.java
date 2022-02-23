package com.spring.blogdynaccurate.repository;


import com.spring.blogdynaccurate.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDynaRepository extends JpaRepository<Post, Long> {
}
