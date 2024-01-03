package com.example.chatgpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @AllArgsConstructor
    @Getter
    public static class Choice {

        private String text;
        private Integer index;
        private String logprobs;

        @JsonProperty("finish_reason")
        private String finishReason;
    }
}
