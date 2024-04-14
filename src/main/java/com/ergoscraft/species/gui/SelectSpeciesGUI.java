package com.ergoscraft.species.gui;
import com.ergoscraft.species.species.SpeciesType;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SelectSpeciesGUI {
    private final Inventory inventory;
    public SelectSpeciesGUI(){
        inventory = generateInventory();
    }

    private Inventory generateInventory(){
        Inventory inv = Bukkit.createInventory(null, 3*9, "Choose a Species");

        ItemStack elf = new ItemStack(SpeciesType.ELF.getIcon());
        ItemMeta elfmeta = elf.getItemMeta();
        assert elfmeta != null;
        elfmeta.setDisplayName(SpeciesType.ELF.getDisplayName());
        elf.setItemMeta(elfmeta);
        inv.setItem(10, elf);

        ItemStack ewok = new ItemStack(SpeciesType.EWOK.getIcon());
        ItemMeta ewokmeta = ewok.getItemMeta();
        assert ewokmeta != null;
        ewokmeta.setDisplayName(SpeciesType.EWOK.getDisplayName());
        ewok.setItemMeta(ewokmeta);
        inv.setItem(13, ewok);

        ItemStack tidewalker = new ItemStack(SpeciesType.TIDEWALKER.getIcon());
        ItemMeta tidewalkermeta = tidewalker.getItemMeta();
        assert tidewalkermeta != null;
        tidewalkermeta.setDisplayName(SpeciesType.TIDEWALKER.getDisplayName());
        tidewalker.setItemMeta(tidewalkermeta);
        inv.setItem(16, tidewalker);

        return inv;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
