package com.example.mapper.demo1.Dao;

import com.example.mapper.demo1.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostDao extends JpaRepository<Post, Integer> {
    public Optional<Post> findById(Integer id);
}
