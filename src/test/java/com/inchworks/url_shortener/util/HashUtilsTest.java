package com.inchworks.url_shortener.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashUtilsTest {

    @Test
    void generateShortHash_ShouldReturnValidHash_WhenValidInput() {
        String userId = "user123";
        String longUrl = "https://example.com";

        String shortHash = HashUtils.generateShortHash(userId, longUrl);

        assertNotNull(shortHash);
        assertEquals(8, shortHash.length());
        assertTrue(shortHash.matches("[a-zA-Z0-9]+"));
    }

    @Test
    void generateShortHash_ShouldReturnDifferentHashes_ForDifferentInputs() {
        String hash1 = HashUtils.generateShortHash("user123", "https://example.com");
        String hash2 = HashUtils.generateShortHash("user456", "https://example.com");

        assertNotEquals(hash1, hash2);
    }



    @Test
    void encodeBase62_ShouldReturnValidBase62String() {
        byte[] sampleBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String encoded = HashUtils.encodeBase62(sampleBytes);

        assertNotNull(encoded);
        assertTrue(encoded.matches("[a-zA-Z0-9]+"));
    }
}
