package com.shiva.chatbot.controller;

import com.shiva.chatbot.service.IChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatController {

    @Autowired
    private IChatBotService chatBotService;

    @GetMapping("/chat")
    public String chat(Model model) {
        return "chat";
    }

    @PostMapping("/chat")
    public ResponseEntity<String> getChatResponse(@RequestBody String userInput) {
        String botResponse = chatBotService.getChatResponse(userInput);
        botResponse = botResponse.replaceAll("\n", "<br> ");
        return ResponseEntity.ok(botResponse);
    }

}
