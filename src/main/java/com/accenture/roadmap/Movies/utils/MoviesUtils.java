package com.accenture.roadmap.Movies.utils;

import com.accenture.roadmap.Movies.model.MovieDTO;
import com.accenture.roadmap.Movies.model.MovieEntity;
import com.accenture.roadmap.Movies.model.MovieForm;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MoviesUtils {

    public static List<MovieDTO> map(List<MovieEntity> movies) {
        return movies
                .stream()
                .map(MoviesUtils::toDTO)
                .collect(toList());
    }

    public static MovieDTO toDTO(MovieEntity it) {
        return new MovieDTO(it.getId(), it.getName(), it.getLength(), it.getAverageRate());
    }

    public static void merge(MovieForm form, MovieEntity entity) {
        entity.setName(form.getName());
        entity.setLength(form.getLength());
    }
}
