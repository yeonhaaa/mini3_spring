package com.example.mini3_spring.repository;

import com.example.mini3_spring.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByEmail(String email);

    public void save(long id);
}