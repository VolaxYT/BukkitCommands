package fr.volax.heal;

import org.bukkit.plugin.java.JavaPlugin;

public class HealPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("heal").setExecutor(new HealCommand());
    }
}
