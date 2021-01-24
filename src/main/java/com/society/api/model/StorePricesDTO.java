package com.society.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorePricesDTO {

    private List<PriceInfo> storePrices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PriceInfo {

        private String name;
        private double price;
        private String link;
    }
}
