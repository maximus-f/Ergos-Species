package com.ergoscraft.species.species;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Elf implements Species {
    private final Player player;
    public Elf(Player player){
        this.player = player;

    }

    @Override
    public SpeciesType getType() {
        return SpeciesType.ELF;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
