package com.ergoscraft.species.gui;

import com.ergoscraft.species.Ergos_Species;
import com.ergoscraft.species.manager.SpeciesManager;
import com.ergoscraft.species.species.SpeciesType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import java.util.HashMap;

public class GUIManager implements Listener {
    private static final HashMap<Class<?>, Inventory> guis = new HashMap<>();
    private static final HashMap<Inventory, Class<?>> inventoryClassMap = new HashMap<>();

    public static Inventory getInventory(Class<?> clazz){
        return guis.computeIfAbsent(clazz, n -> generateGUI(clazz));
    }

    private static Inventory generateGUI(Class<?> clazz) {
        Inventory inventory;
        switch (clazz.getSimpleName()){
            case "SelectSpeciesGUI":
                inventory = new SelectSpeciesGUI().getInventory();
                break;
            default:
                return null;
        }
        inventoryClassMap.put(inventory,clazz);
        return inventory;
    }

    @EventHandler
    public static void onInventoryClick(InventoryClickEvent e){
        Inventory inventory = e.getClickedInventory();
        if (!guis.containsValue(inventory)) return;
        e.setCancelled(true);
        Class<?> origin = inventoryClassMap.get(inventory);
        switch (origin.getSimpleName()){
            case "SelectSpeciesGUI":
                computeSelectSpecies(e);
                break;
            default:
                break;
        }
    }

    private static void computeSelectSpecies(InventoryClickEvent e) {
        SpeciesManager speciesManager = Ergos_Species.getSpeciesManager();
        switch (e.getSlot())
        {
            case 10:
                speciesManager.chooseSpecies((Player) e.getWhoClicked(), SpeciesType.ELF);
                break;
            case 13:
                speciesManager.chooseSpecies((Player) e.getWhoClicked(), SpeciesType.EWOK);
                break;
            case 16:
                speciesManager.chooseSpecies((Player) e.getWhoClicked(), SpeciesType.TIDEWALKER);
                break;
        }
        e.getWhoClicked().closeInventory();
    }
}
