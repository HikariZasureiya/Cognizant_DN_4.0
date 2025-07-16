package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;

@RestController
public class Auth {
    private static final Logger LOGGER = LoggerFactory.getLogger(Auth.class);
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - /authenticate");
        LOGGER.debug("Authorization Header: {}", authHeader);

        Map<String, String> map = new HashMap<>();
        map.put("token", "");
        LOGGER.info("END - /authenticate");
        return map;
    }
}