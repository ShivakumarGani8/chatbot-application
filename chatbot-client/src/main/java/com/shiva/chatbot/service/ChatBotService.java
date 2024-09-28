package com.shiva.chatbot.service;

import org.springframework.stereotype.Service;

@Service
public class ChatBotService implements IChatBotService{

    public String getResponse(String message) {
        if (message.equalsIgnoreCase("hello")) {
            return "Hello! How can I assist you today?";
        } else if (message.equalsIgnoreCase("how are you?")) {
            return "I'm just a bot, but I'm doing great! How about you?";
        } else {
            return "I'm not sure I understand. Could you please clarify?";
        }
    }
}
