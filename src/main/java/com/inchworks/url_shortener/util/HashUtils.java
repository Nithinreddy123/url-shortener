package com.inchworks.url_shortener.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class HashUtils {

    public static String generateShortHash(String userId, String longUrl) {
        try {
            String input = userId + longUrl;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return encodeBase62(hashBytes).substring(0, 8);
        } catch (Exception e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }
    public static String encodeBase62(byte[] hashBytes) {
        String base64 = Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes);
        return base64.replaceAll("[^a-zA-Z0-9]", "");
    }
}
