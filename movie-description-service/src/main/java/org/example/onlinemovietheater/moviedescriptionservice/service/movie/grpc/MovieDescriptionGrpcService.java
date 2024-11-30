package org.example.onlinemovietheater.moviedescriptionservice.service.movie.grpc;

import com.example.grpc.movie.description.MovieDescriptionDatabaseService;
import com.example.grpc.movie.description.MovieDescriptionServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.onlinemovietheater.moviedescriptionservice.model.elasticsearch.document.MovieDescription;
import org.example.onlinemovietheater.moviedescriptionservice.service.movie.MovieDescriptionService;
import org.example.onlinemovietheater.moviedescriptionservice.service.movie.converter.grpc.MovieDescriptionGrpcConverter;

@GrpcService
@RequiredArgsConstructor
public class MovieDescriptionGrpcService extends MovieDescriptionServiceGrpc.MovieDescriptionServiceImplBase {
    private final MovieDescriptionService movieDescriptionService;

    @Override
    public void saveMovieDescription(MovieDescriptionDatabaseService.MovieDescriptionMessage request, StreamObserver<MovieDescriptionDatabaseService.BooleanMessage> responseObserver) {
        responseObserver.onNext(MovieDescriptionGrpcConverter.convert(movieDescriptionService.saveMovieDescription(MovieDescriptionGrpcConverter.convert(request))));
        responseObserver.onCompleted();
    }

    @Override
    public void getMovieDescriptionIdByDescription(MovieDescriptionDatabaseService.StringMessage request, StreamObserver<MovieDescriptionDatabaseService.ListStringMessage> responseObserver) {
        try {
            responseObserver.onNext(MovieDescriptionGrpcConverter.convert(movieDescriptionService.getAllByDescription(request.getString())
                    .stream()
                    .map(MovieDescription::getId)
                    .toList()));
        } catch (Exception e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        }
        responseObserver.onCompleted();
    }
}
