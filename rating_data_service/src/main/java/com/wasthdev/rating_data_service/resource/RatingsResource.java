package com.wasthdev.rating_data_service.resource;

import com.wasthdev.rating_data_service.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRatingInfo(@PathVariable("movieId") String movieId){
        return new Rating("2456",4);
    }
}
