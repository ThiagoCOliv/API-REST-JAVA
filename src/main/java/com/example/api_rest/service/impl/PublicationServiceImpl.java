package com.example.api_rest.service.impl;

import com.example.api_rest.domain.model.Publication;
import com.example.api_rest.domain.repository.PublicationRepository;
import com.example.api_rest.service.PublicationService;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class PublicationServiceImpl implements PublicationService
{
    private final PublicationRepository publicationRepository;
    
    public PublicationServiceImpl(PublicationRepository publicationRepository)
    {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Publication findById(Long id) {
        return publicationRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Publication create(Publication publication) {
        if(publication.getId() != null && publicationRepository.existsById(publication.getId()))
        {
            throw new IllegalArgumentException("Este id já é utilizado");
        }
        
        return publicationRepository.save(publication);
    }
}
