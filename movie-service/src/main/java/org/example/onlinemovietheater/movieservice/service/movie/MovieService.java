package org.example.onlinemovietheater.movieservice.service.movie;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.movieservice.model.movie.dto.request.MovieModel;
import org.example.onlinemovietheater.movieservice.service.movie.description.MovieDescriptionService;
import org.example.onlinemovietheater.movieservice.service.movie.name.MovieNameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieNameService movieNameService;
    private final MovieDescriptionService movieDescriptionService;

    public void saveMovie(MovieModel movieModel) {
        movieNameService.saveMovieName(movieModel.getName());
        Long movieId = movieNameService.getMovieNameIdByName(movieModel.getName());
        movieDescriptionService.saveMovieDescription(movieId, movieModel.getDescription());
    }

    public List<String> getMoviesByDescription(String description) {
        List<Long> idList = movieDescriptionService.getMoviesIdByDescription(description);
        return idList.stream().map(movieNameService::getMovieNameById).toList();
    }
}
