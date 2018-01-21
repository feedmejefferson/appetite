package com.jeffersonfeedme.hunger.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cafeteria {
    @JsonProperty("food-list")
    private Food[] foodList;

    public Food getRandomFood() {
        return foodList[(int) (Math.random() * foodList.length)];
    }
}
