package com.example.api_rest.domain.repository;

import com.example.api_rest.domain.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> 
{}
