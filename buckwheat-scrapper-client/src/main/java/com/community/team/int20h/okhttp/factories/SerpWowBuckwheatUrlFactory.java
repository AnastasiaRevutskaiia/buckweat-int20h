package com.community.team.int20h.okhttp.factories;

import okhttp3.HttpUrl;

public class SerpWowBuckwheatUrlFactory {
    private SerpWowBuckwheatUrlFactory() {
    }

    public static String initialize(String token) {
        final HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.serpwow.com/live/search").newBuilder();
        urlBuilder.addQueryParameter("api_key", token)
                .addQueryParameter("q", "гречка")
                .addQueryParameter("search_type", "shopping")
                .addQueryParameter("gl", "ua")
                .addQueryParameter("hl", "uk")
                .addQueryParameter("location", "Ukraine")
                .addQueryParameter("google_domain", "google.com.ua")
                .addQueryParameter("page", "1");
        return urlBuilder.build().toString();
    }
}
