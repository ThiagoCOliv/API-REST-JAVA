package com.example.api_rest.service;

import com.example.api_rest.domain.model.Publication;

public interface PublicationService 
{
    Publication findById(Long id);
    
    Publication create(Publication publication);
}
