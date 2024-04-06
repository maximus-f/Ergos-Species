package com.ergoscraft.species.placeholders;

import com.ergoscraft.species.Ergos_Species;
import com.ergoscraft.species.api.API;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DisplayNamePlaceholder extends PlaceholderExpansion {
    private final API api;
    private final String identifier;
    private final String author;
    private final String version;
    public DisplayNamePlaceholder(Plugin plugin) {
        api = Ergos_Species.getApi();
        identifier = "species_displayname";
        author = "ErgosSpecies";
        version = plugin.getDescription().getVersion();
    }

    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        return api.getSpecies(player).getType().getDisplayName();
    }

    @Override
    public boolean persist() {
        return true;
    }
    @Override
    public @NotNull String getIdentifier() {
        return identifier;
    }

    @Override
    public @NotNull String getAuthor() {
        return author;
    }

    @Override
    public @NotNull String getVersion() {
        return version;
    }
}