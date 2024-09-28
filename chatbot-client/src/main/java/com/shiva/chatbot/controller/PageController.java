package com.shiva.chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/chat")
    public String index(Model model) {
        return "chat";  // Ensure chat.html exists in the templates folder
    }

}
