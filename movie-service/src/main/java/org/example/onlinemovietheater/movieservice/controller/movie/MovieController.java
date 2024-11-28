package org.example.onlinemovietheater.movieservice.controller.movie;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.movieservice.model.movie.dto.request.MovieDescriptionModel;
import org.example.onlinemovietheater.movieservice.service.movie.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<String> saveMovieDescription(@RequestBody MovieDescriptionModel model) {
        movieService.saveMovieDescription(model);
        return ResponseEntity.ok("hello");
    }

    @GetMapping
    public ResponseEntity<String> getMoviesByDescription(@RequestParam("description") String description){
        movieService.getMoviesByDescription(description);
        return ResponseEntity.ok("hello lol xd");
    }
}
