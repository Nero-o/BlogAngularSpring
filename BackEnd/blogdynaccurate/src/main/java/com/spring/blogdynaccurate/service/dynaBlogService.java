package com.spring.blogdynaccurate.service;

import com.spring.blogdynaccurate.model.Post;

import java.util.List;

public interface dynaBlogService {

    List<Post> findAll();
    Post findById(Long id);
    Post Save(Post post);
}
