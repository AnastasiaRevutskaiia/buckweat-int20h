package com.society.service;

import com.google.common.collect.ImmutableList;
import com.society.api.model.StorePricesDTO;
import org.springframework.stereotype.Service;

@Service
public class StorePricesService {

    public StorePricesDTO getStorePrices(String goodName) {
        return new StorePricesDTO(ImmutableList.of(
                new StorePricesDTO.PriceInfo("Buckwheat_1", 25.50, "https://rozetka.com.ua/ua/240938491/p240938491/"),
                new StorePricesDTO.PriceInfo("Buckwheat_2", 26.50, "https://rozetka.com.ua/ua/240938491/p240938491/"),
                new StorePricesDTO.PriceInfo("Buckwheat_3", 27.50, "https://rozetka.com.ua/ua/240938491/p240938491/"),
                new StorePricesDTO.PriceInfo("Buckwheat_4", 28.50, "https://rozetka.com.ua/ua/240938491/p240938491/"),
                new StorePricesDTO.PriceInfo("Buckwheat_5", 29.50, "https://rozetka.com.ua/ua/240938491/p240938491/"),
                new StorePricesDTO.PriceInfo("Buckwheat_6", 30.50, "https://rozetka.com.ua/ua/240938491/p240938491/"),
                new StorePricesDTO.PriceInfo("Buckwheat_7", 31.50, "https://rozetka.com.ua/ua/240938491/p240938491/")
        ));
    }
}
