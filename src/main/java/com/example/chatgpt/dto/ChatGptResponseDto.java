package com.example.chatgpt.dto;

import io.github.flashvayne.chatgpt.dto.Choice;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatGptResponseDto {

    private String id;
    private String object;
    private LocalDate created;
    private String model;
    private List<Choice> choices;
}
