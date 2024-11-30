package org.example.onlinemovietheater.movieservice.service.movie.name.converter.grpc;

import com.example.grpc.movie.name.MovieNameDatabaseService;

public class MovieNameGrpcConverter {
    public static MovieNameDatabaseService.StringMessage convert(String string) {
        return MovieNameDatabaseService.StringMessage.newBuilder()
                .setString(string)
                .build();
    }

    public static MovieNameDatabaseService.LongMessage convert(Long longg){
        return MovieNameDatabaseService.LongMessage.newBuilder()
                .setLong(longg)
                .build();
    }
}
