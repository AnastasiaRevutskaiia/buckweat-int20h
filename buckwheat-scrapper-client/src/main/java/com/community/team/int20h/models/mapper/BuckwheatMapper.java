package com.community.team.int20h.models.mapper;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.community.team.int20h.models.BuckwheatDTO;
import com.community.team.int20h.models.Currency;
import com.community.team.int20h.models.SerpWowBuckwheatResponse;
import com.community.team.int20h.models.WeightPoints;

public class BuckwheatMapper implements Function<SerpWowBuckwheatResponse, BuckwheatDTO> {
    private static final NumberFormat UKRAINE_NUMBER_FORMAT = NumberFormat.getInstance(Locale.forLanguageTag("uk-UA"));
    private static final Pattern WEIGHT_PATTERN =
            Pattern.compile("(\\d+)(\\s*)((кг)|(г))");

    @Override
    public BuckwheatDTO apply(SerpWowBuckwheatResponse response) {
        double weight;
        try {
            weight = extractWeightInGramsFromTitle(response.getTitle());
        }
        catch (ParseException e) {
            weight = 0;
        }

        return BuckwheatDTO.builder()
                .setWeightInGrams(weight)
                .setCurrency(Currency.UAH.getValue())
                .setName(response.getTitle())
                .setPrice(response.getPrice())
                .setStoreLink(response.getLink())
                .setStoreName(response.getMerchant())
                .setImageUrl(response.getImage())
                .build();
    }

    private static double extractWeightInGramsFromTitle(String title) throws ParseException {
        Matcher weightMatcher = WEIGHT_PATTERN.matcher(title);
        if (!weightMatcher.find()) {
            return 0.0;
        }
        final String weightPointsExtracted = weightMatcher.group(3);
        final WeightPoints weightPoints = WeightPoints.fromValue(weightPointsExtracted);

        final String weightExtracted = weightMatcher.group(1);
        final Number weightNumber = UKRAINE_NUMBER_FORMAT.parse(weightExtracted);
        final double weight = weightNumber.doubleValue();

        return weightPoints.getRelativeIndexToGram() * weight;
    }
}
