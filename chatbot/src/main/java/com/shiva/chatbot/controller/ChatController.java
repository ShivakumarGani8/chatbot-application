package com.shiva.chatbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @PostMapping("/chat")
    public ResponseEntity<String> getChatResponse(@RequestBody String userInput) {
        String botResponse = generateBotResponse(userInput);
        return ResponseEntity.ok(botResponse);
    }

    // Example bot logic based on keywords
    private String generateBotResponse(String userInput) {
        String lowerCaseInput = userInput.toLowerCase();

        if (lowerCaseInput.contains("hello")) {
            return "Hi there! How can I assist you today?";
        } else if (lowerCaseInput.contains("help")) {
            return "I'm here to help! What do you need assistance with?";
        } else {
            return "I'm not sure how to respond to that.";
        }
    }
}
