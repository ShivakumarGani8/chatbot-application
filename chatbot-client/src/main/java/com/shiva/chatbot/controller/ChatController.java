package com.shiva.chatbot.controller;

import com.shiva.chatbot.service.ChatBotService;
import com.shiva.chatbot.service.IChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatController {

    @Autowired
    private IChatBotService chatBotService;

    @PostMapping("/chat")
    public ResponseEntity<String> getChatResponse(@RequestBody String userInput) {
        String botResponse = chatBotService.getResponse(userInput);
        botResponse = botResponse.replaceAll("\n", "<br> ");
        return ResponseEntity.ok(botResponse);
    }

}
