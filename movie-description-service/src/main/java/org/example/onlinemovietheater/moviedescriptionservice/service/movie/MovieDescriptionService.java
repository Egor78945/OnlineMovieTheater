package org.example.onlinemovietheater.moviedescriptionservice.service.movie;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.moviedescriptionservice.model.elasticsearch.document.MovieDescription;
import org.example.onlinemovietheater.moviedescriptionservice.repository.movie.MovieDescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieDescriptionService {
    private final MovieDescriptionRepository movieDescriptionRepository;

    public boolean saveMovieDescription(MovieDescription movieDescription){
        movieDescriptionRepository.save(movieDescription);
        return true;
    }

    public List<MovieDescription> getAllByDescription(String description){
        return movieDescriptionRepository.findMovieDescriptionsByDescriptionContaining(description).orElseThrow(() -> new RuntimeException("No matches found"));
    }
}
