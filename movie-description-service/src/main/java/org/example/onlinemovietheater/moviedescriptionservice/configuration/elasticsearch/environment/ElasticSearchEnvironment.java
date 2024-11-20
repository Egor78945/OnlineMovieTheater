package org.example.onlinemovietheater.moviedescriptionservice.configuration.elasticsearch.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchEnvironment {
    private final String ELASTICSEARCH_INDEX_MOVIE_DESCRIPTION;

    public ElasticSearchEnvironment(@Value("${spring.elasticsearch.index.movie-description}") String ELASTICSEARCH_INDEX_MOVIE_DESCRIPTION) {
        this.ELASTICSEARCH_INDEX_MOVIE_DESCRIPTION = ELASTICSEARCH_INDEX_MOVIE_DESCRIPTION;
    }

    public String getELASTICSEARCH_INDEX_MOVIE_DESCRIPTION() {
        return ELASTICSEARCH_INDEX_MOVIE_DESCRIPTION;
    }
}
