package com.example.chatgpt.service;

import static com.example.chatgpt.constants.Constants.AUTHORIZATION;
import static com.example.chatgpt.constants.Constants.BEARER;
import static com.example.chatgpt.constants.Constants.MEDIA_TYPE;

import com.example.chatgpt.config.ChatGptProperties;
import com.example.chatgpt.dto.ChatGptRequestDto;
import com.example.chatgpt.dto.ChatGptResponseDto;
import com.example.chatgpt.dto.QuestionRequestDto;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@RequiredArgsConstructor
public class ChatService {

    private final RestTemplate restTemplate;
    private final ChatGptProperties chatGptProperties;
    private final ChatgptService chatgptService;

    // sdk
    public String getChat(QuestionRequestDto requestDto) {
        return chatgptService.sendMessage(requestDto.getQuestion());
    }

    // rest
    public ChatGptResponseDto askQuestion(QuestionRequestDto requestDto) {
        return this.getResponse(
            this.buildHttpEntity(
                new ChatGptRequestDto(
                    chatGptProperties.getModel(),
                    requestDto.getQuestion(),
                    chatGptProperties.getMaxTokens(),
                    chatGptProperties.getTemperature(),
                    chatGptProperties.getTopP()
                )
            )
        );
    }

    private ChatGptResponseDto getResponse(HttpEntity<ChatGptRequestDto> chatGptRequestDtoHttpEntity) {
        ResponseEntity<ChatGptResponseDto> responseEntity = restTemplate.postForEntity(
            chatGptProperties.getUrl(),
            chatGptRequestDtoHttpEntity,
            ChatGptResponseDto.class
        );
        return responseEntity.getBody();
    }

    private HttpEntity<ChatGptRequestDto> buildHttpEntity(ChatGptRequestDto requestDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MEDIA_TYPE));
        headers.add(AUTHORIZATION, BEARER + chatGptProperties.getApiKey());
        return new HttpEntity<>(requestDto, headers);
    }
}
