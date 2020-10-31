package com.example.mapper.demo1.Service;

import com.example.mapper.demo1.Dao.PostDao;
import com.example.mapper.demo1.Entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostDao postDao;

    public Post createPost(Post post) {
        return postDao.save(post);
    }

    public Post getPostById(Integer id) {
        Optional<Post> post = postDao.findById(id);
        return post;
    }
}
