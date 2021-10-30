package com.springstudy.service;

import com.springstudy.model.Post;
import com.springstudy.exception.NotFoundException;
import com.springstudy.repository.PostRepositoryStubImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService{
    private final PostRepositoryStubImpl repository;

    public PostService(PostRepositoryStubImpl repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}