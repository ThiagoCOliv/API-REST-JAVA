package com.example.api_rest.controller;

import com.example.api_rest.domain.model.Comment;
import com.example.api_rest.service.CommentService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/comments")
public class CommentController 
{
    private final CommentService commentService;
    
    public CommentController(CommentService commentService)
    {
        this.commentService = commentService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id)
    {
        var comment = commentService.findById(id);
        return ResponseEntity.ok(comment);
    }
    
    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment commentToCreate)
    {
        var commentCreated = commentService.create(commentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(commentCreated.getId()).toUri();
        return ResponseEntity.created(location).body(commentCreated);
    }
}
