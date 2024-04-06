package com.ergoscraft.species.events;

import com.ergoscraft.species.species.SpeciesType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpeciesChangedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final OfflinePlayer p;
    private final SpeciesType previousSpecies;
    private final SpeciesType newSpecies;
    public SpeciesChangedEvent(OfflinePlayer p, SpeciesType previousSpecies, SpeciesType newSpecies){
        this.p = p;
        this.previousSpecies = previousSpecies;
        this.newSpecies = newSpecies;
    }

    public OfflinePlayer getPlayer() {
        return p;
    }

    public SpeciesType getPreviousSpecies() {
        return previousSpecies;
    }

    public SpeciesType getNewSpecies() {
        return newSpecies;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
