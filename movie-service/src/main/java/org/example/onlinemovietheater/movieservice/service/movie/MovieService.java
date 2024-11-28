package org.example.onlinemovietheater.movieservice.service.movie;

import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.movieservice.model.movie.dto.request.MovieDescriptionModel;
import org.example.onlinemovietheater.movieservice.service.movie.converter.grpc.MovieGrpcConverter;
import org.example.onlinemovietheater.movieservice.service.movie.grpc.MovieGrpcService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieGrpcService movieGrpcService;

    public void saveMovieDescription(MovieDescriptionModel model) {
        //save to psql
        movieGrpcService.saveMovieDescription(MovieGrpcConverter.convert(1L, model.getDescription()));
    }

    public List<String> getMoviesByDescription(String description) {
        List<Long> idList = MovieGrpcConverter.convert(movieGrpcService.getMovieDescriptionIdByDescription(MovieGrpcConverter.convert(description)));
        return null;
    }
}
