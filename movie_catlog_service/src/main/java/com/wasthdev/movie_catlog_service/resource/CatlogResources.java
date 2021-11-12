package com.wasthdev.movie_catlog_service.resource;

import com.wasthdev.movie_catlog_service.model.CatlogItem;
import com.wasthdev.movie_catlog_service.model.Movie;
import com.wasthdev.movie_catlog_service.model.Rating;
import com.wasthdev.movie_catlog_service.model.Userrating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatlogItem> getCatalog(@PathVariable("userId") String userId){


//        List<Rating> ratings = Arrays.asList(
//                new Rating("1234",5),
//                 new Rating("124",5)
//        );

        Userrating ratings = restTemplate.getForObject("http://rating-data-service/ratings/user/"+userId, Userrating.class);
       return ratings.getUserRating().stream().map(rating -> {
                  ///for exach movie Id call movie info and get detauils
                   Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieID(), Movie.class);
///Put them all together
                   return new CatlogItem(movie.getName(),"desc", rating.getRating());
       })
                .collect(Collectors.toList());

    }
}



                 /*
                   Movie movie = webClientBuilder.build()
                           .get()
                           .uri("http://localhost:8082/movies/" + rating.getMovieID())
                           .retrieve()
                           .bodyToMono(Movie.class)
                           .block();
                   */