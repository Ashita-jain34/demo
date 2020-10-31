package com.example.mapper.demo1.Controller;

import com.example.mapper.demo1.Dto.PostDto;
import com.example.mapper.demo1.Entity.Post;
import com.example.mapper.demo1.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PostDto createPost(@RequestBody PostDto postDto) {
        Post post = convertToEntity(postDto);
        Post postCreated = postService.createPost(post);
        return convertToDto(postCreated);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public PostDto getPost(@PathVariable("id") Integer id) {
        return convertToDto(postService.getPostById(id));
    }

    private PostDto convertToDto(Post post) {
        PostDto postDto = modelMapper.map(post, PostDto.class);
        postDto.setId(post.getId());
        return postDto;
    }

    private Post convertToEntity(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        post.setId(postDto.getId());
        return post;
    }
}
