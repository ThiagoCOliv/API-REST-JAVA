package com.example.api_rest.controller;

import com.example.api_rest.domain.model.Like;
import com.example.api_rest.service.LikeService;
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
@RequestMapping("/likes")
public class LikeController 
{
    private final LikeService likeService;
    
    public LikeController(LikeService likeService)
    {
        this.likeService = likeService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Like> findById(@PathVariable Long id)
    {
        var like = likeService.findById(id);
        return ResponseEntity.ok(like);
    }
    
    @PostMapping
    public ResponseEntity<Like> create(@RequestBody Like likeToCreate)
    {
        var likeCreated = likeService.create(likeToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(likeCreated.getId()).toUri();
        return ResponseEntity.created(location).body(likeCreated);
    }
}
