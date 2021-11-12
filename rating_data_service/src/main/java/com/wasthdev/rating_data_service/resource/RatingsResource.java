package com.wasthdev.rating_data_service.resource;

import com.wasthdev.rating_data_service.model.Rating;
import com.wasthdev.rating_data_service.model.Userrating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRatingInfo(@PathVariable("movieId") String movieId){
        return new Rating("2456",4);
    }

    @RequestMapping("/user/{userId}")
    public Userrating getUserRating(@PathVariable("userId") String userId){
        List<Rating> ratings =  Arrays.asList(
                new Rating("1234",5),
                new Rating("124",5)
        );
        Userrating userrating = new Userrating();
        userrating.setUserRating(ratings);
        return userrating;
    }
}


