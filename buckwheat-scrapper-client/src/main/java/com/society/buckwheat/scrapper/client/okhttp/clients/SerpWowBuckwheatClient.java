package com.society.buckwheat.scrapper.client.okhttp.clients;

import com.society.buckwheat.scrapper.client.models.BuckwheatDTO;
import com.society.buckwheat.scrapper.client.models.mapper.BuckwheatMapper;
import com.society.buckwheat.scrapper.client.okhttp.SerpWowBuckwheatResponseParser;
import com.society.buckwheat.scrapper.client.okhttp.SerpWowCall;
import com.society.buckwheat.scrapper.client.okhttp.SerpWowCallHandler;
import com.society.buckwheat.scrapper.client.okhttp.factories.OkHttpClientFactory;
import com.society.buckwheat.scrapper.client.okhttp.factories.SerpWowBuckwheatUrlFactory;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class SerpWowBuckwheatClient {
    private final String serpWowBuckwheatUrl;
    private final SerpWowCallHandler handler;

    public SerpWowBuckwheatClient(SerpWowBuckwheatUrlFactory serpWowBuckwheatUrlFactory) {
        requireNonNull(serpWowBuckwheatUrlFactory, "serpWowBuckwheatUrlFactory");
        this.serpWowBuckwheatUrl = requireNonNull(serpWowBuckwheatUrlFactory.getSerpWowBuckwheatUrl(), "serpWowBuckwheatUrl");
        final SerpWowCall serpWowCall = new SerpWowCall(OkHttpClientFactory.initialize());
        final SerpWowBuckwheatResponseParser parser = new SerpWowBuckwheatResponseParser(new BuckwheatMapper());
        this.handler = new SerpWowCallHandler(serpWowCall, parser);
    }

    public List<BuckwheatDTO> getBuckwheat() {
        return this.handler.handleCall(this.serpWowBuckwheatUrl);
    }
}
