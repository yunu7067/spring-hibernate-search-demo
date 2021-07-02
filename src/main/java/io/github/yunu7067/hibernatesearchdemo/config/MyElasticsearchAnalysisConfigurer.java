package io.github.yunu7067.hibernatesearchdemo.config;

import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext;
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurer;

public class MyElasticsearchAnalysisConfigurer implements ElasticsearchAnalysisConfigurer {
    @Override
    public void configure(ElasticsearchAnalysisConfigurationContext context) {
        System.out.println("DEFINE a NEW ANALYZER");

        /* English Analysis */
        context.analyzer("english").custom()
                .tokenizer("standard")
                .charFilters("html_strip")
                .tokenFilters("lowercase", "snowball_english", "asciifolding");

        context.tokenFilter("snowball_english")
                .type("snowball")
                .param("language", "English");

        context.normalizer("lowercase").custom()
                .tokenFilters("lowercase", "asciifolding");

        System.out.println("DEFINE a NEW ANALYZER:DONE");
    }
}
