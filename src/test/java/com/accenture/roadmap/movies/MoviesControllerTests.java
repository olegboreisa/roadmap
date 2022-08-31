package com.accenture.roadmap.movies;

import com.accenture.roadmap.movies.model.MovieDTO;
import com.accenture.roadmap.movies.model.MovieForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(MoviesController.class)
class MoviesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MoviesService moviesService;

    @Test
    public void shouldReturnSizeAndFirstMovieData() throws Exception {
        when(moviesService.getAll())
                .thenReturn(List.of(new MovieDTO(1, "Titanic", 1.32, 9.6),
                                    new MovieDTO(2, "Home Alone", 2.01, 8.1)));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/movies"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Titanic")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].length", Matchers.is(1.32)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].average", Matchers.is(9.6)))
                .andReturn();
    }

    @Test
    public void shouldReturnMovieDataById() throws Exception {
        when(moviesService.getOne(anyLong()))
                .thenReturn(new MovieDTO(1, "Titanic", 1.32, 9.6));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/movies/one")
                        .param("movieId", "1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("name", Matchers.is("Titanic")))
                .andExpect(MockMvcResultMatchers.jsonPath("length", Matchers.is(1.32)))
                .andExpect(MockMvcResultMatchers.jsonPath("average", Matchers.is(9.6)))
                .andReturn();
    }

    @Test
    public void shouldAddMovie() throws Exception {
        String jsonForm = objectMapper.writeValueAsString(new MovieForm(null, "Home Alone 2", 1.21));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(jsonForm))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void shouldUpdateMovie() throws Exception {
        String form = objectMapper.writeValueAsString(new MovieForm(1L, "Home Alone 2", 1.21));

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(form))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void shouldDeleteMovie() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/movies/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

}