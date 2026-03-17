package com.ashka.springai.springaimultiplellm.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openAi")
public class OpenAIController {
    ChatClient chatClient;

    public OpenAIController(@Qualifier("openAiChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ask/{message}")
    public String askOpenAI(@PathVariable String message){
        return chatClient
                .prompt(message)
                .call()
                .content();
    }
}
