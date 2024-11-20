package org.example.onlinemovietheater.moviedescriptionservice.service.movie.grpc;

import com.example.grpc.movie.MovieDescriptionDatabaseService;
import com.example.grpc.movie.MovieDescriptionServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.onlinemovietheater.moviedescriptionservice.service.movie.MovieDescriptionService;
import org.example.onlinemovietheater.moviedescriptionservice.service.movie.converter.grpc.MovieDescriptionGrpcConverter;

@GrpcService
@RequiredArgsConstructor
public class MovieDescriptionGrpcService extends MovieDescriptionServiceGrpc.MovieDescriptionServiceImplBase {
    private final MovieDescriptionService movieDescriptionService;
    @Override
    public void saveMessageDescription(MovieDescriptionDatabaseService.MovieDescriptionMessage request, StreamObserver<MovieDescriptionDatabaseService.BooleanMessage> responseObserver) {
        responseObserver.onNext(MovieDescriptionGrpcConverter.convert(movieDescriptionService.saveMovieDescription(MovieDescriptionGrpcConverter.convert(request))));
        responseObserver.onCompleted();
    }

    @Override
    public void getMessageDescriptionByDescription(MovieDescriptionDatabaseService.StringMessage request, StreamObserver<MovieDescriptionDatabaseService.ListMovieDescriptionMessage> responseObserver) {
        try {
            responseObserver.onNext(MovieDescriptionGrpcConverter.convert(movieDescriptionService.getAllByDescription(request.getString())));
        } catch (Exception e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
