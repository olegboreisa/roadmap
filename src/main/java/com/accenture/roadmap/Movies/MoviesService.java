package com.accenture.roadmap.Movies;

import com.accenture.roadmap.Movies.model.MovieDTO;
import com.accenture.roadmap.Movies.model.MovieEntity;
import com.accenture.roadmap.Movies.model.MovieForm;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.accenture.roadmap.Movies.utils.MoviesUtils.*;

@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;

    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<MovieDTO> getAll() {
        List<MovieEntity> entities = moviesRepository.findAll();
        return map(entities);
    }

    public MovieDTO getOne(long id) {
        MovieEntity entity = moviesRepository.getReferenceById(id);
        return toDTO(entity);
    }

    public long save(MovieForm form) {
        MovieEntity entity = new MovieEntity();
        merge(form, entity);
        return moviesRepository.save(entity).getId();
    }

    public void update(MovieForm form) {
        MovieEntity entity = moviesRepository.getReferenceById(form.getId());
        merge(form, entity);
        moviesRepository.save(entity);
    }

    public void delete(long movieId) {
        moviesRepository.deleteById(movieId);
    }
}
