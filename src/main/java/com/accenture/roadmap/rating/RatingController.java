package com.accenture.roadmap.rating;

import com.accenture.roadmap.rating.model.RateDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rate")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public void setRate(RateDTO rate) {
        ratingService.setRate(rate);
    }

    @GetMapping("/{movieId}")
    public double getRate(@PathVariable long movieId) {
        return ratingService.getRate(movieId);
    }
}
