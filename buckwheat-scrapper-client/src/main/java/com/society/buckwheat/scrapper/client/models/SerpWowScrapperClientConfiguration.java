package com.society.buckwheat.scrapper.client.models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "serp.wow")
public class SerpWowScrapperClientConfiguration {
    private  String baseUrl;
    private  String token;
    private  String query;
    private  String searchType;
    private  String gl;
    private  String hl;
    private  String location;
    private  String googleDomain;
    private  int page;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    public void setHl(String hl) {
        this.hl = hl;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGoogleDomain(String googleDomain) {
        this.googleDomain = googleDomain;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getToken() {
        return this.token;
    }

    public String getQuery() {
        return this.query;
    }

    public String getSearchType() {
        return this.searchType;
    }

    public String getGl() {
        return this.gl;
    }

    public String getHl() {
        return this.hl;
    }

    public String getLocation() {
        return this.location;
    }

    public String getGoogleDomain() {
        return this.googleDomain;
    }

    public int getPage() {
        return this.page;
    }
}
