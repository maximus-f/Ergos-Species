package com.ergoscraft.species.util;

import com.ergoscraft.species.species.Species;
import com.ergoscraft.species.species.Tidewalker;
import com.ergoscraft.species.species.Elf;
import com.ergoscraft.species.species.Ewok;
import org.bukkit.entity.Player;

public class SpeciesUtil {
    public static Species stringToSpecies(Player player, String string) {
        if (string == null || string.isEmpty()) return null;
        switch (string.toLowerCase()) {
            case "ewok":
                return new Ewok(player);
            case "elve":
                return new Elf(player);
            case "tidewalker":
                return new Tidewalker(player);
            default:
                return null;
        }
    }
}
