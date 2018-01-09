package com.jeffersonfeedme.hunger;

import com.jeffersonfeedme.hunger.resources.HungerResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HungerApplication extends Application<HungerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HungerApplication().run(args);
    }

    @Override
    public String getName() {
        return "Hunger";
    }

    @Override
    public void initialize(final Bootstrap<HungerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HungerConfiguration configuration,
                    final Environment environment) {
        final HungerResource resource = new HungerResource(
            );
            environment.jersey().register(resource);    }

}
