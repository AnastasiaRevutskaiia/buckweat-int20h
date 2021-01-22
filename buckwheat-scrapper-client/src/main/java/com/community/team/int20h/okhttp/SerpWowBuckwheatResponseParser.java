package com.community.team.int20h.okhttp;

import java.util.List;

import com.community.team.int20h.models.BuckwheatDTO;
import com.community.team.int20h.models.SerpWowBuckwheatResponse;
import com.community.team.int20h.models.mapper.BuckwheatMapper;
import com.google.common.collect.ImmutableList;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class SerpWowBuckwheatResponseParser {
    private static final Configuration CONFIGURATION =
            Configuration.builder().mappingProvider(new JacksonMappingProvider()).build();

    private final BuckwheatMapper buckwheatMapper;

    public SerpWowBuckwheatResponseParser(BuckwheatMapper buckwheatMapper) {
        this.buckwheatMapper = requireNonNull(buckwheatMapper, "buckwheatMapper");
    }

    public List<BuckwheatDTO> parse(String json) {
        System.out.println(JsonPath.using(CONFIGURATION).parse(json).read("$.shopping_results[*]").toString());
        final List<SerpWowBuckwheatResponse> serpWowBuckwheatResponses = JsonPath.using(CONFIGURATION).parse(json).read("$.shopping_results[*]['title','price','link','image','merchant']",
                                                                                                   new TypeRef<List<SerpWowBuckwheatResponse>>() {
        });
        return serpWowBuckwheatResponses.stream().map(this.buckwheatMapper).collect(collectingAndThen(toList(),
                                                                                                      ImmutableList::copyOf));
    }
}
