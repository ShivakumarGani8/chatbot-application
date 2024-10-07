package com.shiva.chatbot_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiva.chatbot_service.external.Conversation;
import com.shiva.chatbot_service.external.response.CohereResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatServiceImpl implements IChatService {

    @Value("${app.API_KEY}")
    private String API_KEY;
    private static final String COHERE_API_URL = "https://api.cohere.ai/v1/generate";

    private final WebClient webClient;
    private final Conversation conversation;

    public ChatServiceImpl(WebClient.Builder webClientBuilder,ObjectMapper objectMapper) {
        this.webClient=webClientBuilder.build();;
        conversation=new Conversation();
    }

    private CohereResponse generateText(String prompt) {
        Map<String, Object> requestBody = new HashMap<>();
        String fullPrompt = conversation.getFullConversation() + "\nUser: " + prompt;
        requestBody.put("prompt", fullPrompt);
        requestBody.put("temperature", 0.8);

        System.out.println(API_KEY);

        CohereResponse clientResponse = webClient.post()
                .uri(COHERE_API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve().bodyToMono(CohereResponse.class).block();

        if (clientResponse == null ) {
            throw new RuntimeException();
        }else{
            conversation.addMessage(prompt, clientResponse.getGenerations().get(0).getText());
        }
        System.out.println(conversation.getFullConversation());
        return clientResponse;
    }

    @Override
    public String getResponse(String userInput) {
        CohereResponse response = generateText(userInput);
        return response.getGenerations().get(0).getText();
    }

}

