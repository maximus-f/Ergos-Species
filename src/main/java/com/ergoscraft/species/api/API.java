package com.ergoscraft.species.api;

import com.ergoscraft.species.Ergos_Species;
import com.ergoscraft.species.manager.SpeciesManager;
import com.ergoscraft.species.species.Species;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class API {
    private final SpeciesManager speciesManager;

    /**
     * @param plugin Ergos_Species plugin instance
     */
    public API(Plugin plugin) {
        speciesManager = Ergos_Species.getSpeciesManager();
    }

    /**
     * @param player The target player
     * @return Species
     */
    public Species getSpecies(OfflinePlayer player){
        return speciesManager.getSpecies(player);
    }
}
