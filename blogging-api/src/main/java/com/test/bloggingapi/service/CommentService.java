package com.test.bloggingapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bloggingapi.dao.CommentRepo;
import com.test.bloggingapi.dao.PostRepo;
import com.test.bloggingapi.dao.UsersRepo;
import com.test.bloggingapi.model.Comments;

@Service
public class CommentService {

    @Autowired
    CommentRepo repo;

    @Autowired
    PostRepo pRepo;

    @Autowired
    UsersRepo uRepo;

    public void saveComment(String cmt) {
        Comments newComments = setComments(cmt);
        repo.save(newComments);
    }

    private Comments setComments(String cmt) {
        Comments c = new Comments();
        JSONObject obj = new JSONObject(cmt);
        c.setMsg(obj.getString("message"));
        c.setCreated(LocalDateTime.now());
        int postId = Integer.parseInt(obj.getString("postId"));
        c.setPostId(pRepo.findById(postId).get());
        int userId = Integer.parseInt(obj.getString("userId"));
        c.setUserId(uRepo.findById(userId).get());
        return c;
    }

    public List<Comments> getAllComments() {
        return repo.findAll();
    }

    public void deleteComment(int id) {
        repo.deleteById(id);
    }
    
}
