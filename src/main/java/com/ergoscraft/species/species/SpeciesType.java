package com.ergoscraft.species.species;

public enum SpeciesType {

    HUMAN("Human",""),
    EWOK("§4Ewok","§4Ew"),
    ELF("§eElf","§eEl"),
    TIDEWALKER("§6Tidewalker","§6Tw");

    private final String displayName;

    private final String tag;

    SpeciesType(String displayName, String tag) {
        this.displayName = displayName;
        this.tag = tag;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTag(){
        return tag;
    }
}
