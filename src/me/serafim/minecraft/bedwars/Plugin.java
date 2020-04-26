package me.serafim.minecraft.bedwars;

import me.serafim.minecraft.bedwars.comandos.MuteChat;
import me.serafim.minecraft.bedwars.listeners.Pricipais;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    public static boolean chat = false;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("mute").setExecutor(new MuteChat());
        getServer().getPluginManager().registerEvents(new Pricipais(this), this);
    }

    @Override
    public void onDisable() {

    }
}
