package com.watchlist.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;
    private String release_date;
    private String title;
    private String poster_path;

}
