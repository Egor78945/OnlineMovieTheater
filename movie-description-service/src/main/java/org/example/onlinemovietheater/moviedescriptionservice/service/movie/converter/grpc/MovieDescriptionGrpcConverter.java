package org.example.onlinemovietheater.moviedescriptionservice.service.movie.converter.grpc;

import com.example.grpc.movie.MovieDescriptionDatabaseService;
import org.example.onlinemovietheater.moviedescriptionservice.model.elasticsearch.document.MovieDescription;

import java.util.List;

public class MovieDescriptionGrpcConverter {
    public static MovieDescription convert(MovieDescriptionDatabaseService.MovieDescriptionMessage message) {
        return new MovieDescription(message.getId(), message.getDescription());
    }

    public static MovieDescriptionDatabaseService.MovieDescriptionMessage convert(MovieDescription movieDescription) {
        return MovieDescriptionDatabaseService.MovieDescriptionMessage
                .newBuilder()
                .setId(movieDescription.getId())
                .setDescription(movieDescription.getDescription())
                .build();
    }

    public static MovieDescriptionDatabaseService.BooleanMessage convert(boolean bool) {
        return MovieDescriptionDatabaseService.BooleanMessage
                .newBuilder()
                .setBoolean(bool)
                .build();
    }

    public static MovieDescriptionDatabaseService.ListMovieDescriptionMessage convert(List<MovieDescription> movieDescriptions) {
        return MovieDescriptionDatabaseService.ListMovieDescriptionMessage
                .newBuilder()
                .addAllMessage(movieDescriptions
                        .stream()
                        .map(MovieDescriptionGrpcConverter::convert)
                        .toList())
                .build();
    }
}
