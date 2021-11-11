package com.wasthdev.movie_catlog_service.resource;

import com.wasthdev.movie_catlog_service.model.CatlogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catlog")
public class CatlogResources {

    @RequestMapping("/{userId}")
    public List<CatlogItem> getCatalog(@PathVariable("userId") String userId){
        return Collections.singletonList(new CatlogItem("Test","desc",4));
    }
}
