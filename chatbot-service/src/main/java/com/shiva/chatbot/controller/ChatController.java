package com.shiva.chatbot.controller;

import com.shiva.chatbot.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private IChatService chatService;

    @GetMapping("/response")
    public String response(@RequestParam String userInput){
        return chatService.getResponse(userInput);
    }
}
