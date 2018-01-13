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

@Path("/hunger")
@Produces(MediaType.APPLICATION_JSON)
public class HungerResource {

	private static Logger logger = LoggerFactory.getLogger(HungerResource.class);
	
    public HungerResource() {
    }

    @GET
    @Timed
    public Choice feedMe(@QueryParam("chosen") Optional<String> chosen) {
    	    logger.info("chosen=" + chosen.get());
        return new Choice("0000105.jpg", "0000129.jpg");
    }
}

