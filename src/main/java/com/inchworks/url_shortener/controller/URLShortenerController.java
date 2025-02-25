package com.inchworks.url_shortener.controller;


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
@RequestMapping("/api/url")
public interface URLShortenerController {

    @PostMapping("/shorten")
    ResponseEntity<URLResponse> shortenUrl(@Valid @RequestBody URLRequest urlRequest);


}
