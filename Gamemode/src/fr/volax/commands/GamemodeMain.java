package fr.volax.commands;

import org.bukkit.plugin.java.JavaPlugin;

public class GamemodeMain extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("gm").setExecutor(new GamemodeCommand());
    }
}
