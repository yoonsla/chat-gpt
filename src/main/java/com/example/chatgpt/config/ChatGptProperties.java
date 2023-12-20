package com.example.chatgpt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "chatgpt")
public class ChatGptProperties {

    private String url;
    private String apiKey;
    private String model;
    private Integer maxTokens;
    private Double temperature;
    private Double topP;
}