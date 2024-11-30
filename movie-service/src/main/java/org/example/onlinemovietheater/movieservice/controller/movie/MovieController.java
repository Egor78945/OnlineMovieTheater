package org.example.onlinemovietheater.movieservice.controller.movie;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.movieservice.model.movie.dto.request.MovieModel;
import org.example.onlinemovietheater.movieservice.service.movie.MovieService;
import org.example.onlinemovietheater.movieservice.service.movie.description.MovieDescriptionService;
import org.example.onlinemovietheater.movieservice.service.movie.name.MovieNameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<String> saveMovieDescription(@RequestBody MovieModel model) {
        movieService.saveMovie(model);
        return ResponseEntity.ok("Movie has been saved");
    }

    @GetMapping
    public ResponseEntity<List<String>> getMoviesByDescription(@RequestParam("description") String description) {
        return ResponseEntity.ok(movieService.getMoviesByDescription(description));
    }
}
