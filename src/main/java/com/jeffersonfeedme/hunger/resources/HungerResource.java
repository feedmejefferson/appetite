package com.jeffersonfeedme.hunger.resources;

import com.jeffersonfeedme.hunger.api.Choice;
import com.jeffersonfeedme.hunger.core.Cafeteria;
import com.jeffersonfeedme.hunger.core.Food;
import com.jeffersonfeedme.hunger.core.Strata;
import com.jeffersonfeedme.hunger.core.StratifiedCafeteria;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Random;

@Path("/hunger.json")
@Produces(MediaType.APPLICATION_JSON)
public class HungerResource {

    private static Logger logger = LoggerFactory.getLogger(HungerResource.class);
    private final static int MAX_SESSION_ID = Integer.MAX_VALUE;
    private Cafeteria cafe;
    private StratifiedCafeteria stratified;
    private static final String MODEL_A = "A";
    private static final String MODEL_B = "B";
    
    //TODO these should all be configurable
    private static final int DIMENSIONS = 10;
    private static final int QUANTILES = 10;
    private static final int TOP = 5;
    private static final int BOTTOM = 5;
    
    private static Random random = new Random();

    public HungerResource(Cafeteria cafe, StratifiedCafeteria stratified) {
        this.cafe = cafe;
        this.stratified=stratified;
    }

    @GET
    @Timed
    public Choice feedMe(@QueryParam("searchSession") Optional<Integer> requestSession,
            @QueryParam("chosen") Optional<String> chosen,
            @QueryParam("notChosen") Optional<String> notChosen) {
        
        int searchSession = requestSession.orElse(random.nextInt(MAX_SESSION_ID));
        String model=MODEL_A;
        if(searchSession % 2 == 1) { 
            model=MODEL_B;
        }         
        logger.info("chosen={} notChosen={} searchSession={} model={}", chosen.orElse("NA"), notChosen.orElse("NA"), requestSession.orElse(-1), model);

        // run a 50/50 split between models for now -- refactor everything
        // and make it adjustable with weights and multiple configurable models
        // in the future -- big TODO
        if(model==MODEL_A) { 
            return modelA(searchSession);
        } else {
            return modelB(searchSession);
        }
        
        
        
    }
    
    private Choice modelA(int session) {
        Food a = cafe.getRandomFood();
        Food b = cafe.getRandomFood();
        while(b == a) {
            b = cafe.getRandomFood();
        }
        
        return new Choice(a.getImage(), b.getImage(), session);
    }
    
    private Choice modelB(int session) {
        String strataKey = "dimension-" + (random.nextInt(DIMENSIONS) +1) + "-quantile-" + (random.nextInt(QUANTILES)+1);
        Strata strata = stratified.getStrata(strataKey);
        return new Choice(strata.getBottom()[random.nextInt(BOTTOM)].getImage(),
                strata.getTop()[random.nextInt(TOP)].getImage(),
                                session);
        
               
    }
}
