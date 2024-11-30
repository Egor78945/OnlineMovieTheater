package org.example.onlinemovietheater.movienameservice.service.movie.converter.grpc;

import com.example.grpc.movie.name.MovieNameDatabaseService;
import org.example.onlinemovietheater.movienameservice.model.entity.Movie;

public class MovieNameGrpcConverter {
    public static Movie convert(MovieNameDatabaseService.StringMessage stringMessage) {
        return new Movie(stringMessage.getString());
    }

    public static MovieNameDatabaseService.LongMessage convert(Long longg) {
        return MovieNameDatabaseService.LongMessage.newBuilder()
                .setLong(longg)
                .build();
    }

    public static MovieNameDatabaseService.StringMessage convert(String string) {
        return MovieNameDatabaseService.StringMessage.newBuilder()
                .setString(string)
                .build();
    }
}
