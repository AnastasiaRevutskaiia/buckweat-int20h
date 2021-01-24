package com.society.buckwheat.scrapper.client.models;

import java.util.Objects;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = SerpWowBuckwheatResponse.Builder.class)
public class SerpWowBuckwheatResponse {
    private final String title;
    private final String link;
    private final double price;
    private final String merchant;
    private final String image;

    public SerpWowBuckwheatResponse(Builder builder) {
        checkArgument(builder.price >= 0, "price must be >= 0");
        this.price = builder.price;
        this.title = requireNonNull(builder.title, "title");
        this.link = requireNonNull(builder.link, "link");
        this.merchant = requireNonNull(builder.merchant, "merchant");
        this.image = requireNonNull(builder.image, "image");
    }

    public String getTitle() {
        return this.title;
    }

    public String getLink() {
        return this.link;
    }

    public double getPrice() {
        return this.price;
    }

    public String getMerchant() {
        return this.merchant;
    }

    public String getImage() {
        return this.image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SerpWowBuckwheatResponse that = (SerpWowBuckwheatResponse) o;
        return Double.compare(that.price, this.price) == 0 &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.link, that.link) &&
                Objects.equals(this.merchant, that.merchant) &&
                Objects.equals(this.image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.link, this.price, this.merchant, this.image);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SerpWowBuckwheatResponse.class.getSimpleName() + "[", "]")
                .add("title='" + this.title + "'")
                .add("link='" + this.link + "'")
                .add("price=" + this.price)
                .add("merchant='" + this.merchant + "'")
                .add("imageUrl='" + this.image + "'")
                .toString();
    }


    @JsonPOJOBuilder
    public static class Builder {
        private String title;
        private String link;
        private double price;
        private String merchant;
        private String image;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withLink(String link) {
            this.link = link;
            return this;
        }

        public Builder withPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder withMerchant(String merchant) {
            this.merchant = merchant;
            return this;
        }

        public Builder withImage(String imageUrl) {
            this.image = imageUrl;
            return this;
        }

        public SerpWowBuckwheatResponse build() {
            return new SerpWowBuckwheatResponse(this);
        }
    }
}
