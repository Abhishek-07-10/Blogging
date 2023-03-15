package com.test.bloggingapi.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.bloggingapi.model.Comments;
import com.test.bloggingapi.service.CommentService;

@RestController
public class CommentControl {
    
    @Autowired
    CommentService service;


    @PostMapping("/comment")
    public void addComment(@RequestBody String cmt){
        service.saveComment(cmt);
    }

    @GetMapping("/get-all-comments")
    public List<Comments> getAllComments(){
        return service.getAllComments();
    }

    @DeleteMapping("delete-comment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable int id){
        service.deleteComment(id);
        return new ResponseEntity<>("Deleted", HttpStatus.CREATED);
    }
}
