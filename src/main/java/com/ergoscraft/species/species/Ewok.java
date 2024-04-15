package com.ergoscraft.species.species;


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Ewok implements Species{
    private final Player player;
    public Ewok(Player player){
        this.player = player;

    }
    @Override
    public SpeciesType getType() {
        return SpeciesType.EWOK;
    }
    @Override
    public Player getPlayer() {
        return player;
    }
}
