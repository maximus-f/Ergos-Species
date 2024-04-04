package com.ergoscraft.species.species;

public enum SpeciesType {

    HUMAN("Human"),
    EWOK("Ewok"),
    ELVE("Elve"),
    TIDEWALKER("Tidewalker");

    private final String displayName;

    SpeciesType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
