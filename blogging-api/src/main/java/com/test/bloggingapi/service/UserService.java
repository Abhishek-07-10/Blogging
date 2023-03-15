package com.test.bloggingapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bloggingapi.dao.UsersRepo;
import com.test.bloggingapi.model.Users;

@Service
public class UserService {

    @Autowired
    UsersRepo repo;

    public void createUser( Users user) {
        repo.save(user);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }

    public void updateUser(int id, Users user) {
        Users u = repo.findById(id).get();
        u.setEmail(user.getEmail());
        u.setUserName(user.getUserName());
        repo.save(u);
    }
    
}
