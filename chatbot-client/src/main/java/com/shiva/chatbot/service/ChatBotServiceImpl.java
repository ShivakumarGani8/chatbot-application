package com.shiva.chatbot.service;

import com.shiva.chatbot.external.response.client.IChatController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatBotServiceImpl implements IChatBotService{

    @Autowired
    private IChatController chatController;

    public String getChatResponse(String userInput){
        String message=  chatController.response(userInput);
        return message;
    }
}
