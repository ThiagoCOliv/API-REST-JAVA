package com.example.api_rest.controller;

import com.example.api_rest.domain.model.Publication;
import com.example.api_rest.service.PublicationService;
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
@RequestMapping("/publications")
public class PublicationController 
{
    private final PublicationService publicationService;
    
    public PublicationController(PublicationService publicationService)
    {
        this.publicationService = publicationService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Publication> findById(@PathVariable Long id)
    {
        var publication = publicationService.findById(id);
        return ResponseEntity.ok(publication);
    }
    
    @PostMapping
    public ResponseEntity<Publication> create(@RequestBody Publication publication)
    {
        var publicationCreated = publicationService.create(publication);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(publicationCreated.getId()).toUri();
        return ResponseEntity.created(location).body(publicationCreated);
    }
}
