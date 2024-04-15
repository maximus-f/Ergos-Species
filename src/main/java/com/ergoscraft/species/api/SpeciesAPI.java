package com.ergoscraft.species.api;

import com.ergoscraft.species.ErgosSpecies;
import com.ergoscraft.species.manager.SpeciesManager;
import com.ergoscraft.species.species.Species;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

public class SpeciesAPI {
    private final SpeciesManager speciesManager;

    /**
     * @param plugin Ergos_Species plugin instance
     */
    public SpeciesAPI(Plugin plugin) {
        speciesManager = ErgosSpecies.getSpeciesManager();
    }

    /**
     * @param player The target player
     * @return Species
     */
    public Species getSpecies(OfflinePlayer player){
        return speciesManager.getSpecies(player);
    }
}
