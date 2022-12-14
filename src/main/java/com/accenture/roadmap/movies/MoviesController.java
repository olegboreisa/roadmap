package com.accenture.roadmap.movies;

import com.accenture.roadmap.movies.model.MovieDTO;
import com.accenture.roadmap.movies.model.MovieForm;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping
    public List<MovieDTO> getAll() {
       return moviesService.getAll();
    }

    @GetMapping("/one")
    public MovieDTO getOne(@RequestParam long movieId) {
        return moviesService.getOne(movieId);
    }

    @PostMapping
    public long save(@RequestBody MovieForm form) {
        return moviesService.save(form);
    }

    @PutMapping
    public void update(@RequestBody MovieForm form) {
        moviesService.update(form);
    }

    @DeleteMapping("/{movieId}")
    public void delete(@PathVariable long movieId) {
        moviesService.delete(movieId);
    }

}

// ADD COMMENT