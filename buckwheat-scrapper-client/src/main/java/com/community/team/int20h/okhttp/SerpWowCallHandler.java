package com.community.team.int20h.okhttp;

import java.io.IOException;
import java.util.List;

import com.community.team.int20h.models.BuckwheatDTO;
import com.google.common.collect.ImmutableList;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

public class SerpWowCallHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(SerpWowCallHandler.class);
    private final SerpWowCall caller;
    private final SerpWowBuckwheatResponseParser parser;

    public SerpWowCallHandler(SerpWowCall caller, SerpWowBuckwheatResponseParser parser) {
        this.caller = requireNonNull(caller, "caller");
        this.parser = requireNonNull(parser, "parser");
    }

    public List<BuckwheatDTO> handleCall(String url) {
        try (Response response = this.caller.call(url)) {
            if (!response.isSuccessful()) {
                LOGGER.error("Error occurred during call on url=[" + url + "], response=[" + response + "]");
                return ImmutableList.of();
            }
            return this.parser.parse(response.body().string());
        }
        catch (IOException e) {
            LOGGER.error("Error occurred during call on url=[" + url + "], error=[" + e.getMessage() + "]");
            return ImmutableList.of();
        }
    }
}
