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
public class AuthController {
    private final UserService userService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String password) {
        User user = new User();
        user.setUsername(name);
        user.setPassword(passwordEncoder.encode(password));

        userService.saveUser(user);
        return "redirect:/login";
    }



    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";
    }
}
