package org.example.onlinemovietheater.movienameservice.service.movie.grpc;

import com.example.grpc.movie.name.MovieNameDatabaseService;
import com.example.grpc.movie.name.MovieNameServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.onlinemovietheater.movienameservice.model.entity.Movie;
import org.example.onlinemovietheater.movienameservice.service.movie.MovieNameService;
import org.example.onlinemovietheater.movienameservice.service.movie.converter.grpc.MovieNameGrpcConverter;

@GrpcService
@RequiredArgsConstructor
public class MovieNameGrpcService extends MovieNameServiceGrpc.MovieNameServiceImplBase {
    private final MovieNameService movieNameService;

    @Override
    public void saveMovie(MovieNameDatabaseService.StringMessage request, StreamObserver<MovieNameDatabaseService.LongMessage> responseObserver) {
        Movie movieName = MovieNameGrpcConverter.convert(request);
        movieNameService.saveMovie(movieName);
        try {
            responseObserver.onNext(MovieNameGrpcConverter.convert(movieNameService.getMovieByName(movieName.getName()).getId()));
        } catch (Exception e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getMovieId(MovieNameDatabaseService.StringMessage request, StreamObserver<MovieNameDatabaseService.LongMessage> responseObserver) {
        try {
            Movie movieName = MovieNameGrpcConverter.convert(request);
            responseObserver.onNext(MovieNameGrpcConverter.convert(movieNameService.getMovieByName(movieName.getName()).getId()));
        } catch (Exception e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getMovieById(MovieNameDatabaseService.LongMessage request, StreamObserver<MovieNameDatabaseService.StringMessage> responseObserver) {
        try {
            Movie movie = movieNameService.getMovieById(request.getLong());
            responseObserver.onNext(MovieNameGrpcConverter.convert(movie.getName()));
        } catch (Exception e){
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        }
        responseObserver.onCompleted();
    }
}
