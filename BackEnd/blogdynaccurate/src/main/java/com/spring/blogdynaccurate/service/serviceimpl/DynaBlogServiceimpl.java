package com.spring.blogdynaccurate.service.serviceimpl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.blogdynaccurate.model.Post;
import com.spring.blogdynaccurate.repository.BlogDynaRepository;
import com.spring.blogdynaccurate.service.dynaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynaBlogServiceimpl implements dynaBlogService {

    @Autowired
    BlogDynaRepository blogDynaRepository;
    @Override
    public List<Post> findAll() {
        return blogDynaRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return blogDynaRepository.findById(id).get();
    }

    @Override
    public Post Save(Post post) {
        return blogDynaRepository.save(post);
    }
}
