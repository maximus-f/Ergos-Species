package com.ergoscraft.species.species;

import org.bukkit.entity.Player;

public interface Species {
    /**
     * @return SpeciesType
     */
    SpeciesType getType();
    /**
     * @return Player
     */
    Player getPlayer();
}

