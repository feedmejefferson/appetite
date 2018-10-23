package com.jeffersonfeedme.hunger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jeffersonfeedme.hunger.core.Cafeteria;
import com.jeffersonfeedme.hunger.core.StratifiedCafeteria;

import io.dropwizard.Configuration;

public class HungerConfiguration extends Configuration {

    @JsonProperty
    @Valid
    private Cafeteria cafeteria;

    @JsonProperty("stratified-cafeteria")
    @Valid
    private StratifiedCafeteria stratifiedCafeteria;

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public StratifiedCafeteria getStratifiedCafeteria() {
        return stratifiedCafeteria;
    }

}
