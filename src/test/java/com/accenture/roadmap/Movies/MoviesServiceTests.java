package com.accenture.roadmap.Movies;

import com.accenture.roadmap.Movies.model.MovieDTO;
import com.accenture.roadmap.Movies.model.MovieEntity;
import com.accenture.roadmap.Movies.model.MovieForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) //JUnit 5
public class MoviesServiceTests {

    @Mock
    private MoviesRepository moviesRepository;

    @InjectMocks
    private MoviesService moviesService;

    @Test
    public void shouldReturnAllDatabaseMoviesSize() {
        when(moviesRepository.findAll())
                .thenReturn(List.of(
                        new MovieEntity(1L, "Titanic", 1.32, 90, 10, 9.0),
                        new MovieEntity(2L, "Home Alone", 2.01, 81, 10, 8.1)));

        List<MovieDTO> movies = moviesService.getAll();

        assertThat(movies, hasSize(2));
    }

    @Test
    public void shouldReturnMovieNameById() {
        when(moviesRepository.getReferenceById(anyLong()))
                .thenReturn(new MovieEntity(1L, "Titanic", 1.32, 90, 10, 9.0));

        MovieDTO movie = moviesService.getOne(anyLong());

        assertEquals("Titanic", movie.getName());
    }

    @Test
    public void shouldVerifyOneCallToDatabase() {
        when(moviesRepository.getReferenceById(anyLong()))
                .thenReturn(new MovieEntity(1L, "Titanic", 1.32, 90, 10, 9.0));

        moviesService.getOne(anyLong());

        verify(moviesRepository, atLeast(1)).getReferenceById(anyLong());
    }

    @Test
    public void shouldReturnNewMovieId() {
        MovieForm form = new MovieForm(null, "Paris Hilton", 1.51);
        MovieEntity newMovie = new MovieEntity(1L, "Paris Hilton", 1.51);
        when(moviesRepository.save(any(MovieEntity.class))).thenReturn(newMovie);

        Long newMovieId = moviesService.save(form);

        assertNotNull(newMovieId);
    }

}
