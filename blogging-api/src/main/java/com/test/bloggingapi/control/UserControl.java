package com.test.bloggingapi.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.bloggingapi.model.Users;
import com.test.bloggingapi.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserControl {

    @Autowired
    UserService service;

    @PostMapping("/users")
    public ResponseEntity<String> createUser( @Valid @RequestBody Users user) {
        service.createUser(user);
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<String> updatePost(@PathVariable int id, @Valid @RequestBody Users user){
        service.updateUser(id, user);
        return new ResponseEntity<>("Updated", HttpStatus.CREATED);
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        service.deleteUser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.CREATED);
    }

    
}
