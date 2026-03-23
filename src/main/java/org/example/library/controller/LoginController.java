package org.example.library.controller;

import org.example.library.entity.User;
import org.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        User user = service.login(username, password);

        if(user != null) {
            if(user.getRole().getName().equals("ADMIN")) {
                return "admin-home";
            } else {
                return "user-home";
            }
        }

        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }
}