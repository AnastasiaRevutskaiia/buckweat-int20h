package com.society.buckwheat.scrapper.client.okhttp.factories;

import okhttp3.OkHttpClient;

public class OkHttpClientFactory {
    private OkHttpClientFactory() {
    }

    public static OkHttpClient initialize() {
        return new OkHttpClient.Builder().build();
    }
}
