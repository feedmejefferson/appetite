package com.jeffersonfeedme.hunger.core;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Provides a stratified list of foods. Foods within a single strata all have
 * something in common -- for instance popularity. Stratifying foods by
 * popularity allows us to show pairs of food that differ more strategically. We
 * gain very little information about a users appetite if we pair a popular food
 * item with an unpopular one (except of course in the unlikely event when they
 * choose the less popular item).
 * 
 * @author dscheffy
 *
 */
public class StratifiedCafeteria {
    private Map<String, Strata> strataMap;

    @JsonCreator
    public StratifiedCafeteria(Map<String, Strata> strataMap) {
        this.strataMap = strataMap;
    }

    public Strata getStrata(String key) {
        return strataMap.get(key);
    }
}
