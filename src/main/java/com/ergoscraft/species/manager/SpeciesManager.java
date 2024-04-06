package com.ergoscraft.species.manager;

import com.ergoscraft.species.events.SpeciesChangedEvent;
import com.ergoscraft.species.species.*;
import com.ergoscraft.species.storage.Storage;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Random;

public class SpeciesManager implements Listener{
    private final Plugin plugin;
    private HashMap<OfflinePlayer, Species> species = new HashMap<>();
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
        return Storage.getSpecies(player) != null ? Storage.getSpecies(player) : generateSpecies((Player) player);
    }
    private Species generateSpecies(Player player) {
        Random random = new Random();
        int index = random.nextInt(3); // Assuming you have 3 species
        Species species;
        switch (index) {
            case 0:
                species = new Ewok(player);
                break;
            case 1:
                species = new Elf(player);
                break;
            default:
                species = new Tidewalker(player);
                break;
        }
        player.sendMessage("§eWhats that I here? You are still a human? Let me choose a Species for you... §a§l" + species.getType().getDisplayName() + " §eit is!");
        setSpecies(player, species);
        return species;
    }

    public void setSpecies(OfflinePlayer player, Species species){
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
}
