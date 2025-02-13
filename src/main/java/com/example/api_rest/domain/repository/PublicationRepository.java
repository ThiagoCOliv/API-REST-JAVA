package com.example.api_rest.domain.repository;

import com.example.api_rest.domain.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long>
{}
