package com.ergoscraft.species.species;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Human implements Species{
    private final Player player;

    public Human(Player player){
        this.player = player;
        for(Entity passenger : player.getPassengers()){
            passenger.remove();
        }
    }
    @Override
    public SpeciesType getType() {
        return SpeciesType.HUMAN;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
