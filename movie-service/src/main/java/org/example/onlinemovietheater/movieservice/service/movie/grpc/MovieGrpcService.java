package org.example.onlinemovietheater.movieservice.service.movie.grpc;

import com.example.grpc.movie.MovieDescriptionDatabaseService;
import com.example.grpc.movie.MovieDescriptionServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieGrpcService {
    @GrpcClient("movie-description-grpc-service")
    private MovieDescriptionServiceGrpc.MovieDescriptionServiceBlockingStub movieDescriptionServiceBlockingStub;

    public MovieDescriptionDatabaseService.BooleanMessage saveMovieDescription(MovieDescriptionDatabaseService.MovieDescriptionMessage message){
        return movieDescriptionServiceBlockingStub.saveMovieDescription(message);
    }

    public MovieDescriptionDatabaseService.ListStringMessage getMovieDescriptionIdByDescription(MovieDescriptionDatabaseService.StringMessage message){
        return movieDescriptionServiceBlockingStub.getMovieDescriptionIdByDescription(message);
    }
}
