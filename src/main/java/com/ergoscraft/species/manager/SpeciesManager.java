package com.ergoscraft.species.manager;

import com.ergoscraft.species.events.SpeciesChangedEvent;
import com.ergoscraft.species.species.*;
import com.ergoscraft.species.storage.Storage;
import com.ergoscraft.species.util.SpeciesUtil;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import java.util.HashMap;

public class SpeciesManager implements Listener{
    private final Plugin plugin;
    private final HashMap<OfflinePlayer, Species> species = new HashMap<>();
    public SpeciesManager(Plugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        species.put(e.getPlayer(), loadSpecies(player));
    }

    public Species getSpecies(OfflinePlayer player) {
        return species.computeIfAbsent(player, n -> loadSpecies(player));
    }

    private Species loadSpecies(OfflinePlayer player) {
        return Storage.getSpecies(player) != null ? Storage.getSpecies(player) : new Human((Player) player);
    }

    private void setSpecies(OfflinePlayer player, Species species){
        SpeciesType type;
        try{
            type = this.species.get(player).getType();
        } catch (NullPointerException e){
            type = SpeciesType.HUMAN;
        }
        Bukkit.getServer().getPluginManager().callEvent(new SpeciesChangedEvent(player, type, species.getType()));
        this.species.put(player, species);
        Storage.saveSpecies(player, species.getType());
    }

    public void chooseSpecies(OfflinePlayer player, SpeciesType species){
        if (getSpecies(player).getType() == SpeciesType.HUMAN){
            Storage.setSwaps(player,1);
            setSpecies(player, SpeciesUtil.stringToSpecies((Player) player,species.toString()));
        } else reChooseSpecies(player,species);
    }

    public void reChooseSpecies(OfflinePlayer player, SpeciesType species){
        int swaps = Storage.getSwaps(player);
        if (swaps > 0){
            Storage.setSwaps(player,swaps-1);
            setSpecies(player, SpeciesUtil.stringToSpecies((Player) player,species.toString()));
        } else {
            Player p = (Player) player;
            p.closeInventory();
            p.sendMessage("§cYou don't have any species Swaps remaining.");
        }
    }
}
