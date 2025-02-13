package com.example.api_rest.domain.repository;

import com.example.api_rest.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>
{}
