package com.ergoscraft.species.placeholders;

import com.ergoscraft.species.ErgosSpecies;
import com.ergoscraft.species.api.SpeciesAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DisplayNamePlaceholder extends PlaceholderExpansion {
    private final SpeciesAPI api;
    private final String identifier;
    private final String author;
    private final String version;
    public DisplayNamePlaceholder(Plugin plugin) {
        api = ErgosSpecies.getApi();
        identifier = "species";
        author = "ErgosSpecies";
        version = plugin.getDescription().getVersion();
    }

    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        if (params.isEmpty()) return api.getSpecies(player).getType().getDisplayName();
        else return api.getSpecies(player).getType().getTag();
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
