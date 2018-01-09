package com.jeffersonfeedme.hunger.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    private String first;
    private String second;

    public Choice() {
        // Jackson deserialization
    }

    public Choice(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @JsonProperty
    public String getFirst() {
        return first;
    }

    @JsonProperty
    public String getSecond() {
        return second;
    }
}

