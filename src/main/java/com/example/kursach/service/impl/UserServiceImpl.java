package com.example.kursach.service.impl;

import com.example.kursach.model.User;
import com.example.kursach.repository.UserRepository;
import com.example.kursach.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public boolean isVotingsAuthor(Long votingsId, String username) {
        return userRepository.findByVotingsId(votingsId)
                .map(User::getUsername)
                .map(username::equals)
                .orElse(false);
    }

    @Override
    public User findByUsername(String username) {
       return userRepository.findByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("User with username %s is not found".formatted(username)));
    }

}
