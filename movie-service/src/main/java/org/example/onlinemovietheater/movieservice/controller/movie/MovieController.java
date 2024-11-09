package org.example.onlinemovietheater.movieservice.controller.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello");
    }
}
