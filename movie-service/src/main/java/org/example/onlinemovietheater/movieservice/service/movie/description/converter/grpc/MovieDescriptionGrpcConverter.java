package org.example.onlinemovietheater.movieservice.service.movie.description.converter.grpc;

import com.example.grpc.movie.description.MovieDescriptionDatabaseService;

import java.util.List;

public class MovieDescriptionGrpcConverter {
    public static MovieDescriptionDatabaseService.MovieDescriptionMessage convert(Long id, String description) {
        return MovieDescriptionDatabaseService.MovieDescriptionMessage
                .newBuilder()
                .setId(id.toString())
                .setDescription(description)
                .build();
    }

    public static MovieDescriptionDatabaseService.StringMessage convert(String message) {
        return MovieDescriptionDatabaseService.StringMessage
                .newBuilder()
                .setString(message)
                .build();
    }

    public static List<Long> convert(MovieDescriptionDatabaseService.ListStringMessage listStringMessage) {
        return listStringMessage.getMessageList()
                .stream()
                .map(Long::parseLong)
                .toList();
    }
}
