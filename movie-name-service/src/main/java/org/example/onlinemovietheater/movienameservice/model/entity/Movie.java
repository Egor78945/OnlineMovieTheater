package org.example.onlinemovietheater.movienameservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movie")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public Movie() {
    }
}
