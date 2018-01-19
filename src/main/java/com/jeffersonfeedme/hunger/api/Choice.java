package com.jeffersonfeedme.hunger.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    // TODO: refactor and get this out of here when we implement basic auth
    private int searchSession;
    private String a;
    private String b;

    public Choice() {
        // Jackson deserialization
    }

    public Choice(String a, String b, int searchSession) {
        this.a = a;
        this.b = b;
        this.searchSession = searchSession;
    }

    @JsonProperty
    public String getA() {
        return a;
    }

    @JsonProperty
    public String getB() {
        return b;
    }

    @JsonProperty
    public int getSearchSession() {
        return searchSession;
    }
}

