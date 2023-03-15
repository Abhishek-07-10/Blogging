package com.test.bloggingapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.bloggingapi.model.Users;

public interface UsersRepo extends JpaRepository<Users,Integer> {
    
}
