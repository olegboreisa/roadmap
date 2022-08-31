package com.accenture.roadmap.rating;

import com.accenture.roadmap.movies.model.MovieEntity;
import com.accenture.roadmap.movies.MoviesRepository;
import com.accenture.roadmap.rating.model.RateDTO;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private static final int ADDITIONAL_VOTE = 1;

    private final MoviesRepository moviesRepository;

    public RatingService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public void setRate(RateDTO rate) {
        MovieEntity entity = moviesRepository.getReferenceById(rate.getMovieId());
        int total = entity.getTotalRate() + rate.getRate();
        int votes = entity.getTotalVotes() + ADDITIONAL_VOTE;
        double average = ((double) total) / votes;
        entity.setTotalRate(total);
        entity.setTotalVotes(votes);
        entity.setAverageRate(average);
        moviesRepository.save(entity);
    }

    public double getRate(long movieId) {
        MovieEntity entity = moviesRepository.getReferenceById(movieId);
        return entity.getAverageRate();
    }

}
