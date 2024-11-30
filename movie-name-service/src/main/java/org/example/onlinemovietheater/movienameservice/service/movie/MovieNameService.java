package org.example.onlinemovietheater.movienameservice.service.movie;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.movienameservice.model.entity.Movie;
import org.example.onlinemovietheater.movienameservice.repository.movie.MovieRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieNameService {
    private final MovieRepository movieRepository;

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.findMovieByName(name).orElseThrow(() -> new RuntimeException(String.format("Movie with name '%s' has not found.", name)));
    }

    public Movie getMovieById(Long id){
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Movie with id '%s' has not found.", id)));
    }
}