package com.inchworks.url_shortener.service;

import com.inchworks.url_shortener.constants.AppConstants;
import com.inchworks.url_shortener.util.CommonUtils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class URLShortenerServiceTest {

    private final URLShortenerService urlShortenerService = new URLShortenerService();

    @Test
    void generateShortUrl_ShouldReturnShortUrl_WhenValidInput() {
        String userId = "user123";
        String longUrl = "https://example.com";

        try (MockedStatic<CommonUtils> mockedStatic = mockStatic(CommonUtils.class)) {
            // Mock the static method
            mockedStatic.when(() -> CommonUtils.generateShortHash(userId, longUrl))
                    .thenReturn("abc12345");

            String shortUrl = urlShortenerService.generateShortUrl(userId, longUrl);

            assertEquals(AppConstants.BASE_URL + "abc12345", shortUrl);
        }
    }

    @Test
    void generateShortUrl_ShouldNotReturnNull() {
        String userId = "user456";
        String longUrl = "https://spring.io";

        try (MockedStatic<CommonUtils> mockedStatic = mockStatic(CommonUtils.class)) {
            mockedStatic.when(() -> CommonUtils.generateShortHash(userId, longUrl))
                    .thenReturn("xyz98765");

            String shortUrl = urlShortenerService.generateShortUrl(userId, longUrl);

            assertNotNull(shortUrl);
        }
    }
}
