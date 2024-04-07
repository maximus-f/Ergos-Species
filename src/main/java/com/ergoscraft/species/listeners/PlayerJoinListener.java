package com.ergoscraft.species.listeners;

import com.ergoscraft.species.Ergos_Species;
import com.ergoscraft.species.api.API;
import com.ergoscraft.species.gui.GUIManager;
import com.ergoscraft.species.gui.SelectSpeciesGUI;
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
        e.getPlayer().sendMessage("§eWelcome back " + api.getSpecies(e.getPlayer()).getType().getDisplayName());
        e.getPlayer().openInventory(GUIManager.getInventory(SelectSpeciesGUI.class));
    }
}
