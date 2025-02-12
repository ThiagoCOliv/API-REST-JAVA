package com.example.api_rest.domain.repository;

import com.example.api_rest.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User, Long>
{}
