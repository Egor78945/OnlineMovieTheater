package org.example.onlinemovietheater.movieservice.service.movie.name.grpc;

import com.example.grpc.movie.name.MovieNameDatabaseService;
import com.example.grpc.movie.name.MovieNameServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieNameGrpcService {
    @GrpcClient("movie-name-service")
    private MovieNameServiceGrpc.MovieNameServiceBlockingStub movieNameServiceBlockingStub;

    public void saveMovieName(MovieNameDatabaseService.StringMessage name){
        movieNameServiceBlockingStub.saveMovie(name);
    }
    public MovieNameDatabaseService.LongMessage getIdByMovieName(MovieNameDatabaseService.StringMessage name){
        return movieNameServiceBlockingStub.getMovieId(name);
    }

    public MovieNameDatabaseService.StringMessage getMovieNameById(MovieNameDatabaseService.LongMessage id) {
        return movieNameServiceBlockingStub.getMovieById(id);
    }
}
