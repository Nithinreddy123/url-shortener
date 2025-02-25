package com.inchworks.url_shortener.service;

import com.inchworks.url_shortener.constants.AppConstants;
import com.inchworks.url_shortener.util.CommonUtils;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService {

    public String generateShortUrl(String userId, String longUrl) {
        String hash = CommonUtils.generateShortHash(userId, longUrl);
        return AppConstants.BASE_URL + hash;
    }
}
