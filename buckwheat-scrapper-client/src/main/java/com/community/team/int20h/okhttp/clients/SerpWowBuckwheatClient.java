package com.community.team.int20h.okhttp.clients;

import java.util.List;

import com.community.team.int20h.models.BuckwheatDTO;
import com.community.team.int20h.models.mapper.BuckwheatMapper;
import com.community.team.int20h.okhttp.factories.OkHttpClientFactory;
import com.community.team.int20h.okhttp.SerpWowBuckwheatResponseParser;
import com.community.team.int20h.okhttp.factories.SerpWowBuckwheatUrlFactory;
import com.community.team.int20h.okhttp.SerpWowCall;
import com.community.team.int20h.okhttp.SerpWowCallHandler;

import static java.util.Objects.requireNonNull;

public class SerpWowBuckwheatClient {
    private final String serpWowBuckwheatUrl;
    private final SerpWowCallHandler handler;

    public SerpWowBuckwheatClient(String serpWowClientToken) {
        requireNonNull(serpWowClientToken, "serpWowClientToken");
        this.serpWowBuckwheatUrl = SerpWowBuckwheatUrlFactory.initialize(serpWowClientToken);
        final SerpWowCall serpWowCall = new SerpWowCall(OkHttpClientFactory.initialize());
        final SerpWowBuckwheatResponseParser parser = new SerpWowBuckwheatResponseParser(new BuckwheatMapper());
        this.handler = new SerpWowCallHandler(serpWowCall, parser);
    }

    public List<BuckwheatDTO> getBuckwheat() {
        return this.handler.handleCall(this.serpWowBuckwheatUrl);
    }
}
