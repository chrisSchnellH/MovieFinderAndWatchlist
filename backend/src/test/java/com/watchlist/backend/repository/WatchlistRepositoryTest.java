package com.watchlist.backend.repository;

import com.watchlist.backend.entity.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class WatchlistRepositoryTest {

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Test
    public void testFindByMovieId() {
        // Setup test data
        Movie movie = new Movie();
        movie.setMovieId(123L);
        movie.setTitle("Test Movie");
        watchlistRepository.save(movie);

        // Execute the repository method
        Optional<Movie> foundMovie = watchlistRepository.findByMovieId(123L);

        // Verify the results
        assertTrue(foundMovie.isPresent());
        assertEquals("Test Movie", foundMovie.get().getTitle());
    }

    @Test
    public void testFindAll() {
        // Setup test data
        Movie movie = new Movie();
        movie.setTitle("Another Movie");
        watchlistRepository.save(movie);

        // Execute the repository method
        assertEquals(1, watchlistRepository.findAll().size());
    }
}

