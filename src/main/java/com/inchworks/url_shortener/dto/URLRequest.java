package com.inchworks.url_shortener.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class URLRequest {
    @NotBlank(message = "User ID cannot be empty")
    private String userId;

    @NotBlank(message = "URL cannot be empty")
    @Size(max = 2048, message = "URL length must be less than 2048 characters")
    private String longUrl;
}
