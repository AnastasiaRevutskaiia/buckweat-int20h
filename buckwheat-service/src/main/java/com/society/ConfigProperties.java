package com.society;

import com.society.buckwheat.scrapper.client.models.SerpWowScrapperClientConfiguration;
import com.society.buckwheat.scrapper.client.okhttp.clients.SerpWowBuckwheatClient;
import com.society.buckwheat.scrapper.client.okhttp.factories.SerpWowBuckwheatUrlFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {

    @Bean
    public SerpWowBuckwheatUrlFactory serpWowBuckwheatUrlFactory(SerpWowScrapperClientConfiguration configuration) {
        return new SerpWowBuckwheatUrlFactory(configuration);
    }

    @Bean
    public SerpWowBuckwheatClient serpWowBuckwheatClient(SerpWowBuckwheatUrlFactory factory) {
        return new SerpWowBuckwheatClient(factory);
    }

}
