package com.accenture.roadmap.Movies;

import com.accenture.roadmap.Movies.model.MovieDTO;
import com.accenture.roadmap.Movies.model.MovieForm;
import com.accenture.roadmap.RoadmapApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(
        classes = RoadmapApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MoviesIntegrationTests {

    private static final String MOVIE_URL = "http://localhost:8080/api/movies";
    private static final MovieForm FORM = new MovieForm(null, "Home Alone", 1.12);

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldGetMovieName() {
        String URL = UriComponentsBuilder.fromUriString(MOVIE_URL + "/one")
                .queryParam("movieId", "6")
                .toUriString();

        MovieDTO movie = restTemplate.getForObject(URL, MovieDTO.class);
        assertNotNull(movie);
        assertEquals("Titanic", movie.getName());
    }

    @Test
    public void shouldAddNewMovie() {
        ResponseEntity<Void> response = restTemplate.postForEntity(MOVIE_URL, FORM, Void.class);
        assertEquals(200, response.getStatusCodeValue());
    }
//
//    @Test
//    public void shouldDeleteMovie() {
//        String URL = UriComponentsBuilder.fromUriString(MOVIE_URL + "/one")
//                .queryParam("movieId", "6")
//                .toUriString();
//
//        restTemplate.delete(MOVIE_URL, ResponseEntity.class);
//    }

}
