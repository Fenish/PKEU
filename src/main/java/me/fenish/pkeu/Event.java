package me.fenish.pkeu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class Event implements Listener {
    Main pl;
    public Event(){
        pl = Main.getInstance();
    }

    @EventHandler
    public void invClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("§9Plugin Menajeri")) {
            if(event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
                event.setCancelled(true);
                if (event.getCurrentItem().getType().equals(Material.SLIME_BALL)) {
                    Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(event.getCurrentItem().getItemMeta().getDisplayName().replace("§a", ""));
                    Bukkit.getServer().getPluginManager().disablePlugin(pl);
                    event.getWhoClicked().closeInventory();
                    Bukkit.getServer().dispatchCommand(event.getWhoClicked(), "pkeu");
                } else if (event.getCurrentItem().getType().equals(Material.MAGMA_CREAM)) {
                    Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(event.getCurrentItem().getItemMeta().getDisplayName().replace("§c", ""));
                    Bukkit.getServer().getPluginManager().enablePlugin(pl);
                    event.getWhoClicked().closeInventory();
                    Bukkit.getServer().dispatchCommand(event.getWhoClicked(), "pkeu");
                }
            }
        }
    }
}
