package org.example.onlinemovietheater.movienameservice.repository.movie;

import org.example.onlinemovietheater.movienameservice.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByName(String name);
}
