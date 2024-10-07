package com.shiva.chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/login")
public class LoginController {

    @GetMapping
    public String showLoginForm() {
        return "login"; // This returns the login.html view
    }

    @PostMapping
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Sample validation
        if ("user".equals(username) && "pass".equals(password)) {
            return "redirect:/chat";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }
    }
}
