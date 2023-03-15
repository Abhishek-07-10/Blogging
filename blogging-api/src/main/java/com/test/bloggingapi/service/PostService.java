package com.test.bloggingapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bloggingapi.dao.PostRepo;
import com.test.bloggingapi.dao.UsersRepo;
import com.test.bloggingapi.model.Post;

@Service
public class PostService {

    @Autowired
    PostRepo repo;

    @Autowired
    UsersRepo uRepo;

    public void savePost(String post) {
        Post newPost = setPost(post);
        repo.save(newPost);
    }

    private Post setPost(String post) {
        JSONObject obj = new JSONObject(post);
        Post p = new Post();
        p.setContent(obj.getString("content"));
        p.setCreated(LocalDateTime.now());
        int id = Integer.parseInt(obj.getString("userId"));
        p.setUserId(uRepo.findById(id).get());
        return p;
    }

    public List<Post> getPost() {
        return repo.findAll();
    }

    public void deletePost(int id) {
        repo.deleteById(id);
    }

    public void updatePost(int id, String post) {
        Post p = repo.findById(id).get();
        Post update = setPost(post);
        p.setContent(update.getContent());
        p.setUserId(update.getUserId());
        repo.save(p);
    }
    
}
