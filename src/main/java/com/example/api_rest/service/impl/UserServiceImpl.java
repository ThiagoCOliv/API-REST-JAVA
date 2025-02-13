package com.example.api_rest.service.impl;

import com.example.api_rest.domain.model.User;
import com.example.api_rest.domain.repository.UserRepository;
import com.example.api_rest.service.UserService;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId()))
        {
            throw new IllegalArgumentException("Este id já é utilizado");
        }
        
        return userRepository.save(userToCreate);
    }
    
}
