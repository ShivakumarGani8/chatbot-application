package com.shiva.chatbot_service.controller;

import com.shiva.chatbot_service.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @Autowired
    private IChatService chatService;

    @GetMapping("/response")
    public String response(@RequestParam String userInput){
        return chatService.getResponse(userInput);
    }
}
