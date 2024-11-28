package org.example.onlinemovietheater.moviedescriptionservice.repository.movie;

import org.example.onlinemovietheater.moviedescriptionservice.model.elasticsearch.document.MovieDescription;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieDescriptionRepository extends ElasticsearchRepository<MovieDescription, String> {
    Optional<List<MovieDescription>> findMovieDescriptionsByDescriptionContaining(String description);
}
