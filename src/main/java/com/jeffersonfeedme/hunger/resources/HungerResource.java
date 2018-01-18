package com.jeffersonfeedme.hunger.resources;

import com.jeffersonfeedme.hunger.api.Choice;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Path("/hunger.json")
@Produces(MediaType.APPLICATION_JSON)
public class HungerResource {

    private static Logger logger = LoggerFactory.getLogger(HungerResource.class);

    public HungerResource() {
    }

    @GET
    @Timed
    public Choice feedMe(@QueryParam("chosen") Optional<String> chosen) {
        logger.info("chosen=" + chosen.orElse("NA"));
        return new Choice(String.format("%07d", 1 + (int)(Math.random() * 200)) + ".jpg",
                String.format("%07d", 1 + (int)(Math.random() * 200)) + ".jpg");
    }
}
