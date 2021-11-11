package com.wasthdev.movie_catlog_service.resource;

import com.wasthdev.movie_catlog_service.model.CatlogItem;
import com.wasthdev.movie_catlog_service.model.Movie;
import com.wasthdev.movie_catlog_service.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catlog")
public class CatlogResources {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatlogItem> getCatalog(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("1234",5),
                new Rating("124",5)
        );
       return ratings.stream().map(rating -> {
                   Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieID(), Movie.class);
                  return new CatlogItem(movie.getName(),"desc", rating.getRating());
       })
                .collect(Collectors.toList());

    }
}
