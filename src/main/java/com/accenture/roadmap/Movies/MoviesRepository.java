package com.accenture.roadmap.Movies;

import com.accenture.roadmap.Movies.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<MovieEntity, Long> {

}
