package com.society.api.controller;

import com.society.api.model.StorePricesDTO;
import com.society.service.StorePricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class StorePricesController {

    private static final String BUCKWHEAT = "buckwheat";

    private final StorePricesService storePricesService;

    @GetMapping("/" + BUCKWHEAT)
    public ResponseEntity<StorePricesDTO> getStorePrices() {
        return ResponseEntity.ok(storePricesService.getStorePrices(BUCKWHEAT));
    }
}
