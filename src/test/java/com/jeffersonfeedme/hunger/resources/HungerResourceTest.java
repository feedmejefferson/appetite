package com.jeffersonfeedme.hunger.resources;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Optional;

import javax.validation.Validator;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.jeffersonfeedme.hunger.HungerConfiguration;
import com.jeffersonfeedme.hunger.api.Choice;

import io.dropwizard.configuration.YamlConfigurationFactory;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jersey.validation.Validators;

public class HungerResourceTest {

    private ObjectMapper objectMapper = Jackson.newObjectMapper();
    private Validator validator = Validators.newValidator();
    private YamlConfigurationFactory<HungerConfiguration> factory =
            new YamlConfigurationFactory<>(HungerConfiguration.class, validator, objectMapper, "dw");

    @Test
    public void testFeedMe() throws Exception {
        File yml = new File(Resources.getResource("fixtures/cafeteria.yml").toURI());
        HungerConfiguration config = factory.build(yml);
        HungerResource res = new HungerResource(config.getCafeteria(), config.getStratifiedCafeteria());
        Choice response = res.feedMe(Optional.of(20), Optional.empty(), Optional.empty());
        assertEquals("The random image name should be 11 characters long.", 11, response.getA().length());
        assertEquals("The random image name should be 11 characters long.", 11, response.getB().length());
        assertEquals("The search session returned should be the same as the one passed in.", 20,
                response.getSearchSession());
        assertNotEquals("The random images should always be different", response.getA(), response.getB());
    }

}
