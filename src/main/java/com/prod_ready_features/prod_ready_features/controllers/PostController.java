package com.prod_ready_features.prod_ready_features.controllers;

import com.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.prod_ready_features.prod_ready_features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

//    public PostController(PostService postService) {
//        this.postService = postService;
//    }

    @GetMapping
    public List<PostDTO> getAllPost(){
        return postService.getALLPosts();
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO inputPost){
        return postService.createNewPost(inputPost);
    }

    @GetMapping("/{postId}")
    public  PostDTO getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public PostDTO updatePost(@RequestBody PostDTO inputPost, @PathVariable Long postId){
        return postService.updatePost(inputPost,postId);
    }
}
