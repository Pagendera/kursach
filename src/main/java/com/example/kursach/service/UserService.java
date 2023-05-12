package com.example.kursach.service;

import com.example.kursach.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {

    boolean isVotingsAuthor(Long votingsId, String username);

    User findByUsername(String username);

    User saveUser(User user);
}
