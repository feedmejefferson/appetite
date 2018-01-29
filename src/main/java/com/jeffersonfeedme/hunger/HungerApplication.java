package com.jeffersonfeedme.hunger;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;

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
    public void run(final HungerConfiguration configuration, final Environment environment) {
        final HungerResource resource = new HungerResource(configuration.getCafeteria());
        environment.jersey().register(resource);
        configureCors(environment);
    }

    private void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }
}
