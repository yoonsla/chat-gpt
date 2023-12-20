package com.example.chatgpt.response;

import lombok.Getter;

@Getter
public class Response<T> {

    private final boolean success;
    private final int httpStatusCode;
    private T result;

    private Response() {
        this.success = true;
        this.httpStatusCode = 200;
    }

    private Response(T result) {
        this.success = true;
        this.httpStatusCode = 200;
        this.result = result;
    }

    public static <T> Response<T> from(T result) {
        return new Response<>(result);
    }
}
