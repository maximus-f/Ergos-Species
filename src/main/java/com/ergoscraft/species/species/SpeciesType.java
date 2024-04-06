package com.ergoscraft.species.species;

public enum SpeciesType {

    HUMAN("Human"),
    EWOK("§4Ewok"),
    ELF("§eElf"),
    TIDEWALKER("§6Tidewalker");

    private final String displayName;

    SpeciesType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
