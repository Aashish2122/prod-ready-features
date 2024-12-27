package com.prod_ready_features.prod_ready_features.services;

import com.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.prod_ready_features.prod_ready_features.entities.PostEntity;
import com.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import com.prod_ready_features.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<PostDTO> getALLPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post Not found with ID: " + postId)
                );
        return modelMapper.map(postEntity,PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        PostEntity oldPost = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No post found with ID: "+postId)
                );
        inputPost.setId(postId);
        modelMapper.map(inputPost,oldPost);
    return modelMapper.map(postRepository.save(oldPost),PostDTO.class);
    }
}
