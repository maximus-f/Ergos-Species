package com.ergoscraft.species.messages;

import com.ergoscraft.species.ErgosSpecies;
import com.ergoscraft.species.util.ConfigUtil;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class Messages {
    private static final HashMap<String, String> messages = new HashMap<>();
    private static Plugin plugin;
    private static final ConfigurationSection configUtil = new ConfigUtil(ErgosSpecies.getPlugin(), "messages.yml").getConfig();
    public static void onEnable(Plugin plugin){
        Messages.plugin = plugin;
    }

    /**
     * @param key The message key
     * @return String
     */
    public static String get(String key) {
        return messages.computeIfAbsent(key, Messages::retrieveMessageFromConfig);
    }

    /**
     * @param key The message to be retrieved
     * @return String
     */
    private static String retrieveMessageFromConfig(String key) {
        String retrievedMessage = configUtil.getString(key);
        if (retrievedMessage == null || retrievedMessage.isEmpty()) {
            retrievedMessage = "§c[Ergos_Species >> Messages.yml] The following message is either missing or not set: §e" + key;
        }
        return retrievedMessage.replace("&","§");
    }

    public static void reload() {
        messages.clear();
    }
}
