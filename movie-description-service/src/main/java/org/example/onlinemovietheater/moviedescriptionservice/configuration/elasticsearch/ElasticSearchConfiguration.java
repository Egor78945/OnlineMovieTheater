package org.example.onlinemovietheater.moviedescriptionservice.configuration.elasticsearch;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.moviedescriptionservice.model.elasticsearch.document.MovieDescription;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;

@Configuration
@RequiredArgsConstructor
public class ElasticSearchConfiguration {
    private final ElasticsearchOperations elasticsearchOperations;

    @PostConstruct
    public void createIndex(){
        IndexOperations indexOperations = elasticsearchOperations.indexOps(MovieDescription.class);

        if(!indexOperations.exists()){
            indexOperations.create();
            indexOperations.putMapping();
            indexOperations.refresh();
        }
    }

}
