package com.community.team.int20h.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.util.Objects.requireNonNull;

public class SerpWowCall {
    private final OkHttpClient client;

    public SerpWowCall(OkHttpClient client) {
        this.client = requireNonNull(client, "client");
    }

    public Response call(String url) throws IOException {
        requireNonNull(url, "url");
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = this.client.newCall(request);
        return call.execute();
    }
}
