package com.accenture.roadmap.Movies;

import com.accenture.roadmap.Movies.model.MovieEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MoviesRepositoryTests {

    @Autowired
    private MoviesRepository moviesRepository;

    @Test
    public void shouldExecuteFindAllMovies() {
        moviesRepository.findAll();
    }

    @Test
    public void shouldSaveMovie() {
        moviesRepository.save(
                new MovieEntity(null, "Barbie Girl", 1.01));
    }

}
