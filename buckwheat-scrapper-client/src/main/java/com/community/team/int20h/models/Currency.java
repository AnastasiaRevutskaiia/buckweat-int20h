package com.community.team.int20h.models;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

public enum Currency {
    UAH("грн");

    private final String value;

    Currency(String value) {
        this.value = requireNonNull(value, "value");
    }

    public String getValue() {
        return this.value;
    }

    public static Currency from(String value) {
        return Arrays.stream(values())
                .filter(type -> type.getValue().equals(value))
                .findFirst()
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "No such enum " + value + " for " + Currency.class.getName()));
    }
}
