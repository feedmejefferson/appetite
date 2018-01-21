package com.jeffersonfeedme.hunger.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.File;

import javax.validation.Validator;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.jeffersonfeedme.hunger.HungerConfiguration;

import io.dropwizard.configuration.YamlConfigurationFactory;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jersey.validation.Validators;
import static org.hamcrest.CoreMatchers.*;

public class CafeteriaTest {

    private final ObjectMapper objectMapper = Jackson.newObjectMapper();
    private final Validator validator = Validators.newValidator();
    private final YamlConfigurationFactory<HungerConfiguration> factory =
            new YamlConfigurationFactory<>(HungerConfiguration.class, validator, objectMapper, "dw");

    @Test
    public void testBuildACafeteria() throws Exception {
        final File yml = new File(Resources.getResource("fixtures/cafeteria.yml").toURI());
        final HungerConfiguration config = factory.build(yml);
        assertThat(config, instanceOf(HungerConfiguration.class));
        Cafeteria cafe = config.getCafeteria();
        assertEquals(cafe.getRandomFood().getImage().length(), 11);
    }


}
