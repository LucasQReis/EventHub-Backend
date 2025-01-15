package com.api.EventHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.EventHub.model.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{
    
}
