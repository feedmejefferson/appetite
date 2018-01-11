package com.jeffersonfeedme.hunger.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    private String a;
    private String b;

    public Choice() {
        // Jackson deserialization
    }

    public Choice(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @JsonProperty
    public String getA() {
        return a;
    }

    @JsonProperty
    public String getB() {
        return b;
    }
}

