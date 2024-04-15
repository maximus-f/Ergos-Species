package com.ergoscraft.species.listeners;

import com.ergoscraft.species.ErgosSpecies;
import com.ergoscraft.species.api.SpeciesAPI;
import com.ergoscraft.species.messages.Messages;
import com.ergoscraft.species.species.SpeciesType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final SpeciesAPI api;

    public PlayerJoinListener(){
        api = ErgosSpecies.getApi();
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e){
        if (api.getSpecies(e.getPlayer()).getType() == SpeciesType.HUMAN){
            e.getPlayer().sendMessage(Messages.get("selectSpeciesReminder"));
        };
    }
}
