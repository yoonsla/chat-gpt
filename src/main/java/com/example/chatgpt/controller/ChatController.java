package com.example.chatgpt.controller;

import com.example.chatgpt.dto.ChatGptRequestDto;
import com.example.chatgpt.dto.ChatGptResponseDto;
import com.example.chatgpt.dto.QuestionRequestDto;
import com.example.chatgpt.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat-gpt")
public class ChatController {

    private final ChatService chatService;

    // sdk
    @PostMapping("")
    public String getChat(@RequestBody QuestionRequestDto requestDto) {
        return chatService.getChat(requestDto);
    }

    // rest api
    @PostMapping("/question")
    public ChatGptResponseDto sendQuestion(@RequestBody QuestionRequestDto requestDto) {
        return chatService.askQuestion(requestDto);
    }
}
