package com.jeffersonfeedme.hunger.resources;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Optional;

class HungerResourceTest {

    @Test
    void test() {
        HungerResource res = new HungerResource();
        assertEquals(11,res.feedMe(Optional.empty()).getA().length());
        assertEquals(11,res.feedMe(Optional.empty()).getB().length());
    }

}
