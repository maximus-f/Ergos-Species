package com.ergoscraft.species.storage;

import com.ergoscraft.species.species.Species;
import com.ergoscraft.species.species.SpeciesType;
import com.ergoscraft.species.util.SpeciesUtil;
import com.ergoscraft.species.storage.mysql.MySQLWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Storage {
    private static MySQLWrapper mySQLWrapper;

    public static void init(Plugin plugin){
        ConfigurationSection config = plugin.getConfig().getConfigurationSection("database");
        assert config != null;
        mySQLWrapper = new MySQLWrapper(config.getString("link"),config.getString("username"),config.getString("password"));
    }
    public static Species getSpecies(OfflinePlayer player) {
        return SpeciesUtil.stringToSpecies((Player) player, mySQLWrapper.getSpecies(player.getUniqueId()));
    }
    public static void saveSpecies(OfflinePlayer player, SpeciesType type) {
        mySQLWrapper.setSpecies(player.getUniqueId(), type.toString());
    }

    public static void shutdown(){
        mySQLWrapper.shutdown();
    }
}
