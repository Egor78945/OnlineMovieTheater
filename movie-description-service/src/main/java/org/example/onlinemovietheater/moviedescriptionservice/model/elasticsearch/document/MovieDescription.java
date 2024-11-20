package org.example.onlinemovietheater.moviedescriptionservice.model.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "#{@environment.getProperty('spring.elasticsearch.index.movie-description')}")
@Data
public class MovieDescription {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String description;

    public MovieDescription(String description, String id) {
        this.description = description;
        this.id = id;
    }

    public MovieDescription() {
    }
}
