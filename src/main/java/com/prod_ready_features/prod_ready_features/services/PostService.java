package com.prod_ready_features.prod_ready_features.services;

import com.prod_ready_features.prod_ready_features.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getALLPosts();
    PostDTO createNewPost (PostDTO postDTO);

    PostDTO getPostById(Long postId);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
