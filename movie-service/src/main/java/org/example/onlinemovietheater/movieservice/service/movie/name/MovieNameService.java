package org.example.onlinemovietheater.movieservice.service.movie.name;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.movieservice.service.movie.name.converter.grpc.MovieNameGrpcConverter;
import org.example.onlinemovietheater.movieservice.service.movie.name.grpc.MovieNameGrpcService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieNameService {
    private final MovieNameGrpcService movieNameGrpcService;

    public void saveMovieName(String name) {
        movieNameGrpcService.saveMovieName(MovieNameGrpcConverter.convert(name));
    }

    public Long getMovieNameIdByName(String name) {
        return movieNameGrpcService.getIdByMovieName(MovieNameGrpcConverter.convert(name)).getLong();
    }

    public String getMovieNameById(Long id){
        return movieNameGrpcService.getMovieNameById(MovieNameGrpcConverter.convert(id)).getString();
    }
}
