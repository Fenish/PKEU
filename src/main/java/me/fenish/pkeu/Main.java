package me.fenish.pkeu;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;
    public static Main getInstance(){
        return instance;
    }
    public static Event event;
    @Override
    public void onEnable() {
        instance = this;
        event = new Event();

        this.getCommand("pkeu").setExecutor(new Komut());
        this.getServer().getPluginManager().registerEvents(event,this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
