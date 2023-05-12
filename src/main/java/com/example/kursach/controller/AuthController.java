package com.example.kursach.controller;

import com.example.kursach.model.User;
import com.example.kursach.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class AuthController {
    private final UserService userService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String password){
        User user = new User();
        user.setUsername(name);
        user.setPassword(passwordEncoder.encode(password));

        userService.saveUser(user);
        return "index";
    }

    @GetMapping
    public String registerPage(){
        return "register";
    }
}
