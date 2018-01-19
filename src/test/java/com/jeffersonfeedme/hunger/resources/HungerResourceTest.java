package com.jeffersonfeedme.hunger.resources;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import com.jeffersonfeedme.hunger.api.Choice;

public class HungerResourceTest {

    @Test
    public void testFeedMe() {
        HungerResource res = new HungerResource();
        Choice response = res.feedMe(Optional.of(20), Optional.empty(), Optional.empty());
        assertEquals("The random image name should be 11 characters long.", 11, response.getA().length());
        assertEquals("The random image name should be 11 characters long.", 11, response.getB().length());
        assertEquals("The search session returned should be the same as the one passed in.", 20,
                response.getSearchSession());
    }

}
