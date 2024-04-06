package com.ergoscraft.species.species;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface Species {
    SpeciesType getType();
    Player getPlayer();
}

