package com.community.team.int20h.models;

import java.util.Objects;
import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

/**
 * Represents single Buckwheat item from parsed website
 */
public class BuckwheatDTO {
    private final String name;
    private final double price;
    private final String currency;
    private final double weightInGrams;
    private final String storeName;
    private final String storeLink;
    private final String imageUrl;

    private BuckwheatDTO(Builder builder) {
        this.name = requireNonNull(builder.name, "name");
        this.storeName = requireNonNull(builder.storeName, "storeName");
        this.storeLink = requireNonNull(builder.storeLink, "storeLink");
        this.currency = requireNonNull(builder.currency, "currency");
        checkArgument(builder.price >= 0, "price must be >= 0");
        checkArgument(builder.weightInGrams >= 0, "weightInGrams must be >= 0");
        this.price = builder.price;
        this.weightInGrams = builder.weightInGrams;
        this.imageUrl = requireNonNull(builder.imageUrl, "imageUrl");
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public double getWeightInGrams() {
        return this.weightInGrams;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public String getStoreLink() {
        return this.storeLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BuckwheatDTO that = (BuckwheatDTO) o;
        return Double.compare(that.price, this.price) == 0 &&
                Double.compare(that.weightInGrams, this.weightInGrams) == 0 &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.currency, that.currency) &&
                Objects.equals(this.storeName, that.storeName) &&
                Objects.equals(this.storeLink, that.storeLink) &&
                Objects.equals(this.imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.price, this.currency, this.weightInGrams, this.storeName, this.storeLink, this.imageUrl);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BuckwheatDTO.class.getSimpleName() + "[", "]")
                .add("name='" + this.name + "'")
                .add("price=" + this.price)
                .add("currency='" + this.currency + "'")
                .add("weightInGrams=" + this.weightInGrams)
                .add("storeName='" + this.storeName + "'")
                .add("storeLink='" + this.storeLink + "'")
                .add("imageUrl='" + this.imageUrl + "'")
                .toString();
    }


    public static class Builder {
        private String imageUrl;
        private String name;
        private double price;
        private String storeName;
        private String storeLink;
        private double weightInGrams;
        private String currency;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStoreName(String storeName) {
            this.storeName = storeName;
            return this;
        }

        public Builder setStoreLink(String storeLink) {
            this.storeLink = storeLink;
            return this;
        }

        public Builder setWeightInGrams(double weightInGrams) {
            this.weightInGrams = weightInGrams;
            return this;
        }

        public Builder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public BuckwheatDTO build() {
            return new BuckwheatDTO(this);
        }
    }
}
