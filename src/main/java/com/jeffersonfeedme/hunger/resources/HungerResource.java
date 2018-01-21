package com.jeffersonfeedme.hunger.resources;

import com.jeffersonfeedme.hunger.api.Choice;
import com.jeffersonfeedme.hunger.core.Cafeteria;
import com.jeffersonfeedme.hunger.core.Food;
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
    private final static int MAX_SESSION_ID = Integer.MAX_VALUE;
    private Cafeteria cafe;

    public HungerResource(Cafeteria cafe) {
        this.cafe = cafe;
    }

    @GET
    @Timed
    public Choice feedMe(@QueryParam("searchSession") Optional<Integer> requestSession,
            @QueryParam("chosen") Optional<String> chosen,
            @QueryParam("notChosen") Optional<String> notChosen) {
        
        logger.info("chosen={} notChosen={} searchSession={}", chosen.orElse("NA"), notChosen.orElse("NA"), requestSession.orElse(-1));
        int searchSession = requestSession.orElse((int)(Math.random() * MAX_SESSION_ID));
        Food a = cafe.getRandomFood();
        Food b = cafe.getRandomFood();
        while(b == a) {
            b = cafe.getRandomFood();
        }
        
        return new Choice(a.getImage(), b.getImage(), searchSession);
    }
}
