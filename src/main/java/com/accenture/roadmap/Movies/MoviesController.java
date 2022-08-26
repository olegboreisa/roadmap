package com.accenture.roadmap.Movies;

import com.accenture.roadmap.Movies.model.MovieDTO;
import com.accenture.roadmap.Movies.model.MovieForm;
import org.springframework.web.bind.annotation.*;

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