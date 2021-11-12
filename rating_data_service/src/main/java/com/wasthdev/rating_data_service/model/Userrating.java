package com.wasthdev.rating_data_service.model;

import java.util.List;

public class Userrating {
    private List<Rating> userRating;

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
