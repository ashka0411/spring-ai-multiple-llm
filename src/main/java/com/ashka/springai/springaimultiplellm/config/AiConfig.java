package com.ashka.springai.springaimultiplellm.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient openAiChatClient(@Qualifier("openAiChatModel") ChatModel chatModel){
        return ChatClient.builder(chatModel)
                .defaultSystem("""
                 You are a weather forecast system.
                 do not answer questions other than weather. 
                 """)
                .build();
    }

    @Bean
    public ChatClient ollamaChatClient(@Qualifier("ollamaChatModel") ChatModel chatModel){
        return ChatClient.builder(chatModel)
                .defaultSystem("""
                 You are a weather forecast system.
                 do not answer questions other than weather. 
                 """)
                .build();
    }
}
