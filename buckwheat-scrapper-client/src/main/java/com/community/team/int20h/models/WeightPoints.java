package com.community.team.int20h.models;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

public enum WeightPoints {
    GRAM("г", 1),
    KG("кг", 1000);

    private final String value;
    private final double relativeIndexToGram;

    WeightPoints(String value, double relativeIndexToGram) {
        this.value = requireNonNull(value, "value");
        checkArgument(relativeIndexToGram > 0, "relativeIndexToGram must be > 0");
        this.relativeIndexToGram = relativeIndexToGram;
    }

    public String getValue() {
        return this.value;
    }

    public double getRelativeIndexToGram() {
        return this.relativeIndexToGram;
    }

    public static WeightPoints fromValue(String value) {
        return Arrays.stream(values())
                .filter(type -> type.getValue().equals(value))
                .findFirst()
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "No such enum " + value + " for " + WeightPoints.class.getName()));
    }
}
