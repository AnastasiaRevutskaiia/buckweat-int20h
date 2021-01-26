package com.society.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StorePricesHealthController {

    @GetMapping("/")
    public String getStorePricesTestMessage() {
        return "Hello from Store Prices App!";
    }
}
