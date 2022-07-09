package com.ironhack.backend.apirest.service;

import com.ironhack.backend.apirest.models.User;

public interface IUserService {
    public User findByUsername(String username);
}

