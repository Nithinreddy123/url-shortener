package com.inchworks.url_shortener.controller.impl;

import com.inchworks.url_shortener.controller.URLShortenerController;
import com.inchworks.url_shortener.dto.URLResponse;
import com.inchworks.url_shortener.dto.URLRequest;
import com.inchworks.url_shortener.service.URLShortenerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class URLShortenerControllerImpl implements URLShortenerController {

    final private URLShortenerService urlShortenerService;
    private static final Logger logger = LoggerFactory.getLogger(URLShortenerControllerImpl.class);

    public URLShortenerControllerImpl(URLShortenerService urlShortenerService){
        this.urlShortenerService = urlShortenerService;
    }

    @Override
    public ResponseEntity<URLResponse> shortenUrl(URLRequest urlRequest) {

        logger.info("Received shorten URL request for userId: {} and longUrl: {}", urlRequest.getUserId(), urlRequest.getLongUrl());

        String shortUrl=urlShortenerService.generateShortUrl(urlRequest.getUserId(), urlRequest.getLongUrl());

        logger.debug("Generated short URL: {}", shortUrl);

        return new ResponseEntity<>(new URLResponse(shortUrl),HttpStatus.OK);
    }





}
