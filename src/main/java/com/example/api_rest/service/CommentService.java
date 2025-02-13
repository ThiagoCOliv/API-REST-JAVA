package com.example.api_rest.service;

import com.example.api_rest.domain.model.Comment;

public interface CommentService 
{
    Comment findById(Long id);
    
    Comment create(Comment comment);
}
