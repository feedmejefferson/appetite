package com.jeffersonfeedme.hunger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jeffersonfeedme.hunger.core.Cafeteria;

import io.dropwizard.Configuration;

public class HungerConfiguration extends Configuration {

    @JsonProperty
    @NotNull
    @Valid
    private Cafeteria cafeteria;

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

}
