package com.shiva.chatbot.external.response.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "iChatController", url= "http://localhost:8081/chat")
public interface IChatController {
    @GetMapping("/response")
    public String response(@RequestParam String userInput);
}
