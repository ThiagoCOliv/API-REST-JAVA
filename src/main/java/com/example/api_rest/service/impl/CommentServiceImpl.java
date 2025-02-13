package com.example.api_rest.service.impl;

import com.example.api_rest.domain.model.Comment;
import com.example.api_rest.domain.repository.CommentRepository;
import com.example.api_rest.service.CommentService;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService
{
    private final CommentRepository commentRepository;
    
    public CommentServiceImpl(CommentRepository commentRepository)
    {
        this.commentRepository = commentRepository;
    }
    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Comment create(Comment comment) {
        if(comment.getId() != null && commentRepository.existsById(comment.getId()))
        {
            throw new IllegalArgumentException("Este id já é utilizado");
        }
        
        return commentRepository.save(comment);
    }
    
}
