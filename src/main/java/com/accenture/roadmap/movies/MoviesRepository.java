package com.accenture.roadmap.movies;

import com.accenture.roadmap.movies.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<MovieEntity, Long> {

}
