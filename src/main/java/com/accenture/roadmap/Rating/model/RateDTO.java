package com.accenture.roadmap.Rating.model;

public class RateDTO {

    private long movieId;
    private int rate;

    public RateDTO(long movieId, int rate) {
        this.movieId = movieId;
        this.rate = rate;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
