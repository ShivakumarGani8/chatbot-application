package com.shiva.chatbot_service.external;

import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private List<String> history;

    public Conversation() {
        this.history = new ArrayList<>();
    }

    public void addMessage(String userPrompt, String cohereResponse) {
        history.add("User: " + userPrompt);
        history.add("Bot: " + cohereResponse);
    }

    public String getFullConversation() {
        return String.join("\n", history);
    }
}
