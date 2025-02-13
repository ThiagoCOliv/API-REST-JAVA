package com.example.api_rest.service;

import com.example.api_rest.domain.model.Like;

public interface LikeService 
{
    Like findById(Long id);
    
    Like create(Like like);
}
