package com.society.api.controller;

import com.society.buckwheat.scrapper.client.models.BuckwheatDTO;
import com.society.service.StorePricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class StorePricesController {

    private static final String BUCKWHEAT = "buckwheat";

    private final StorePricesService storePricesService;

    @GetMapping("/" + BUCKWHEAT)
    public ResponseEntity<List<BuckwheatDTO>> getStorePrices() {
        return ResponseEntity.ok(this.storePricesService.getStorePrices());
    }
}
