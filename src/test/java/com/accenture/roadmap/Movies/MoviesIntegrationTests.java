package com.accenture.roadmap.Movies;

import com.accenture.roadmap.Movies.model.MovieDTO;
import com.accenture.roadmap.Movies.model.MovieForm;
import com.accenture.roadmap.RoadmapApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


@SpringBootTest(
        classes = RoadmapApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MoviesIntegrationTests {

    private static final String DOMAIN_AND_PORT = "http://localhost:8080";
    private static final String GET_ONE = "/api/movies/one?movieId=1";
    private static final String POST = "/api/movies";

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
//    public void shouldGetMovieById() {
//        MovieDTO movie = restTemplate.getForObject(DOMAIN_AND_PORT + GET_ONE, MovieDTO.class);
//    }
//
//    @Test
//    public void shouldAddNewMovie() {
//        MovieForm form = new MovieForm(null, "Why", 1.12);
//        restTemplate.postForEntity(DOMAIN_AND_PORT + POST, form, Void.class);
//    }
}
