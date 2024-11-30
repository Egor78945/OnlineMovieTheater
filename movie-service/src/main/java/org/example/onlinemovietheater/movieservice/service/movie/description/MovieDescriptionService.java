package org.example.onlinemovietheater.movieservice.service.movie.description;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.movieservice.service.movie.description.converter.grpc.MovieDescriptionGrpcConverter;
import org.example.onlinemovietheater.movieservice.service.movie.description.grpc.MovieDescriptionGrpcService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieDescriptionService {
    private final MovieDescriptionGrpcService movieDescriptionGrpcService;

    public void saveMovieDescription(Long id, String description) {
        movieDescriptionGrpcService.saveMovieDescription(MovieDescriptionGrpcConverter.convert(id, description));
    }

    public List<Long> getMoviesIdByDescription(String description) {
        return MovieDescriptionGrpcConverter.convert(movieDescriptionGrpcService.getMovieDescriptionIdByDescription(MovieDescriptionGrpcConverter.convert(description)));
    }
}
