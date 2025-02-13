package com.example.api_rest.service.impl;

import com.example.api_rest.domain.model.Like;
import com.example.api_rest.domain.repository.LikeRepository;
import com.example.api_rest.service.LikeService;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService
{
    private final LikeRepository likeRepository;
    
    public LikeServiceImpl(LikeRepository likeRepository)
    {
        this.likeRepository = likeRepository;
    }
    @Override
    public Like findById(Long id) {
        return likeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Like create(Like like) {
        if(like.getId() != null && likeRepository.existsById(like.getId()))
        {
            throw new IllegalArgumentException("Este id já é utilizado");
        }
        
        return likeRepository.save(like);
    }
    
}
