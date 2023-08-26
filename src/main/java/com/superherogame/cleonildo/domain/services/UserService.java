package com.superherogame.cleonildo.domain.services;

import com.superherogame.cleonildo.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository resourceRepository;

    public UserService(UserRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public
}
