package com.ergoscraft.species.listeners;

import com.ergoscraft.species.Ergos_Species;
import com.ergoscraft.species.api.API;
import com.ergoscraft.species.gui.GUIManager;
import com.ergoscraft.species.gui.SelectSpeciesGUI;
import com.ergoscraft.species.messages.Messages;
import com.ergoscraft.species.species.SpeciesType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final API api;

    public PlayerJoinListener(){
        api = Ergos_Species.getApi();
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e){
        if (api.getSpecies(e.getPlayer()).getType() == SpeciesType.HUMAN){
            e.getPlayer().sendMessage(Messages.get("selectSpeciesReminder"));
        };
    }
}
