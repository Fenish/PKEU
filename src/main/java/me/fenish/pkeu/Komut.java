package me.fenish.pkeu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Komut implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if(command.getName().equalsIgnoreCase("pkeu")){
                if(sender.isOp()) {
                    if (args.length == 0) {
                        Inventory plgui = Bukkit.createInventory(null, 54, "§9Plugin Menajeri");
                        for(int x = 0;x<54;x++){
                            plgui.addItem(new ItemStack(Material.AIR));
                        }
                        Plugin[] pluginler = Bukkit.getServer().getPluginManager().getPlugins();
                        for (Plugin pl : pluginler) {
                            if (!pl.getName().equalsIgnoreCase("PluginiKontrolEtUlan")) {
                                ItemStack plitem = new ItemStack(Material.SLIME_BALL);
                                ItemMeta plmeta = plitem.getItemMeta();
                                plmeta.setDisplayName("§a" + pl.getName());
                                if (!pl.isEnabled()) {
                                    plitem = new ItemStack(Material.MAGMA_CREAM);
                                    plmeta.setDisplayName("§c" + pl.getName());
                                }
                                plitem.setItemMeta(plmeta);
                                plgui.addItem(plitem);
                            }
                        }
                        ((Player) sender).openInventory(plgui);
                    }else{
                        if(args[0].equalsIgnoreCase("aç")){
                            Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(args[1]);
                            Bukkit.getServer().getPluginManager().enablePlugin(pl);
                        }
                        else if(args[0].equalsIgnoreCase("kapat")){
                            Plugin pl = Bukkit.getServer().getPluginManager().getPlugin(args[1]);
                            Bukkit.getServer().getPluginManager().disablePlugin(pl);
                        }
                    }
                }
            }
        }
        return true;
    }

}
