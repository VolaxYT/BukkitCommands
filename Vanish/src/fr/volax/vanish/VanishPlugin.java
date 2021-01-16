package fr.volax.vanish;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class VanishPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("vanish").setExecutor(new VanishClass());
        Bukkit.getPluginManager().registerEvents(new VanishClass(), this);
    }
}
