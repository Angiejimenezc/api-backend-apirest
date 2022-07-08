package com.ironhack.backend.apirest.service;

import com.ironhack.backend.apirest.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {


    @Override
    public User findByUsername(String username) {
        return null;
    }
}

