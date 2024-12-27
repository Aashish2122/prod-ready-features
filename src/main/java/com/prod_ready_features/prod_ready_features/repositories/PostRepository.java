package com.prod_ready_features.prod_ready_features.repositories;

import com.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.prod_ready_features.prod_ready_features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {


}
