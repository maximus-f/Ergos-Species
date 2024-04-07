package com.ergoscraft.species.species;
import org.bukkit.Material;

public enum SpeciesType {

    HUMAN("Human","", Material.GRASS),
    EWOK("§4Ewok","§4Ew", Material.TALL_GRASS),
    ELF("§eElf","§eEl", Material.PINK_STAINED_GLASS),
    TIDEWALKER("§6Tidewalker","§6Tw", Material.PRISMARINE);

    private final String displayName;
    private final String tag;
    private final Material icon;

    SpeciesType(String displayName, String tag, Material icon) {
        this.displayName = displayName;
        this.tag = tag;
        this.icon = icon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTag(){
        return tag;
    }

    public Material getIcon(){
        return icon;
    }
}
