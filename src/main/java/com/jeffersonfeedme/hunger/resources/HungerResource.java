package com.jeffersonfeedme.hunger.resources;

import com.jeffersonfeedme.hunger.api.Choice;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hunger")
@Produces(MediaType.APPLICATION_JSON)
public class HungerResource {

    public HungerResource() {
    }

    @GET
    @Timed
    public Choice feedMe(@QueryParam("lastChoice") Optional<String> lastChoice) {
        return new Choice("Pizza", "Ice Cream");
    }
}

