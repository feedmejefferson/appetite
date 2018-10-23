package com.jeffersonfeedme.hunger.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Provides a single strata of opposing alternatives. Any option from the top
 * should be able to be paired equally well against any food option from the
 * bottom.
 * 
 * This allows us to stratify pairings so that we don't accidentally show
 * something very popular next to something very unpopular.
 * 
 * @author dscheffy
 *
 */
public class Strata {
    @JsonProperty
    private Food[] top;

    @JsonProperty
    private Food[] bottom;

    public Food[] getTop() {
        return top;
    }

    public Food[] getBottom() {
        return bottom;
    }

}
