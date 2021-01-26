package com.society.buckwheat.scrapper.client.okhttp.factories;

import com.society.buckwheat.scrapper.client.models.SerpWowScrapperClientConfiguration;
import okhttp3.HttpUrl;

import static java.util.Objects.requireNonNull;

public class SerpWowBuckwheatUrlFactory {
    private final String serpWowBuckwheatUrl;

    public SerpWowBuckwheatUrlFactory(SerpWowScrapperClientConfiguration configuration) {
        requireNonNull(configuration, "configuration");

        final HttpUrl.Builder urlBuilder = HttpUrl.parse(configuration.getBaseUrl()).newBuilder();
        urlBuilder.addQueryParameter("api_key", configuration.getToken())
            .addQueryParameter("q", configuration.getQuery())
            .addQueryParameter("search_type", configuration.getSearchType())
            .addQueryParameter("gl", configuration.getGl())
            .addQueryParameter("hl", configuration.getHl())
            .addQueryParameter("location", configuration.getLocation())
            .addQueryParameter("google_domain", configuration.getGoogleDomain())
            .addQueryParameter("page", String.valueOf(configuration.getPage()));
        this.serpWowBuckwheatUrl = urlBuilder.build().toString();
    }

    public String getSerpWowBuckwheatUrl() {
        return this.serpWowBuckwheatUrl;
    }
}

