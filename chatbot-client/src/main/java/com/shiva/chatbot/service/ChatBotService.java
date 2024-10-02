package com.shiva.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ChatBotService implements IChatBotService{

    @Autowired
    private RestTemplate restTemplate;

    public String getResponse(String userInput){
        String uri= "http://localhost:8081/response?userInput=".concat(userInput.replaceAll("\"",""));
        String message= restTemplate.getForObject(uri,String.class);
        return message;
    }
}
