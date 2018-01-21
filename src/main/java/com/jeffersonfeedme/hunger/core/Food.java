package com.jeffersonfeedme.hunger.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Food {
    @JsonProperty
    private String image;

    public String getImage() {
        return image;
    }

    public Food(String image) {
        this.image = image;
    }
}
