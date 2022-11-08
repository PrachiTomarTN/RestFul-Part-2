package com.example.RestFulApiPractice.CustomisedException;

import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime time;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime time, String message, String details) {
        this.time = time;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
