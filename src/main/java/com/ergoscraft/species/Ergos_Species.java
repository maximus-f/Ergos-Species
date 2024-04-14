package com.ergoscraft.species;

import com.ergoscraft.species.api.API;
import com.ergoscraft.species.gui.GUIManager;
import com.ergoscraft.species.listeners.PlayerJoinListener;
import com.ergoscraft.species.manager.SpeciesManager;
import com.ergoscraft.species.messages.Messages;
import com.ergoscraft.species.placeholders.DisplayNamePlaceholder;
import com.ergoscraft.species.storage.Storage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Ergos_Species extends JavaPlugin {

    private static Plugin plugin;
    private static API api;
    private static Boolean placeHolderAPI;
    private static SpeciesManager speciesManager;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        saveResource("messages.yml", false);
        Messages.onEnable(this);
        try{
            Storage.init(this);
        } catch (Exception e){
            getLogger().severe(String.format("[%s] - Disabled due to being unable to connect to Database!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getServer().getPluginManager().registerEvents(speciesManager = new SpeciesManager(this),this);
        getServer().getPluginManager().registerEvents(new GUIManager(),this);

        api = new API(this);

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new DisplayNamePlaceholder(this).register();
            placeHolderAPI = true;
            getLogger().info("Custom placeholders registered successfully.");
        } else {
            getLogger().warning("PlaceholderAPI not found. Custom placeholders will not work.");
            placeHolderAPI = false;
        }

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(),this);
    }

    @Override
    public void onDisable() {
        Storage.shutdown();
    }

    public static void log(String message){
        plugin.getServer().getConsoleSender().sendMessage(message);
    }

    public static Plugin getPlugin(){
        return plugin;
    }

    public static API getApi(){
        return api;
    }

    public static SpeciesManager getSpeciesManager() {
        return speciesManager;
    }
}
