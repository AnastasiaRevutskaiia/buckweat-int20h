package com.society.service;

import com.society.buckwheat.scrapper.client.models.BuckwheatDTO;
import com.society.buckwheat.scrapper.client.okhttp.clients.SerpWowBuckwheatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorePricesService {
    private final SerpWowBuckwheatClient client;

    public List<BuckwheatDTO> getStorePrices() {
        return this.client.getBuckwheat();
    }
}
