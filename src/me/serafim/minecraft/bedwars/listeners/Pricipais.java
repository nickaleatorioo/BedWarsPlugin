package me.serafim.minecraft.bedwars.listeners;

import me.serafim.minecraft.bedwars.Plugin;
import org.bukkit.*;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

public class Pricipais implements Listener {
    private Plugin plugin;

    public Pricipais(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(AsyncPlayerChatEvent event) {

        if (Plugin.chat) {
            event.getPlayer().sendMessage("&aO chat está desativado");
            event.setCancelled(true);
            return;
        }

        ItemStack ferro = new ItemStack(Material.IRON_INGOT);
        ItemStack ouro = new ItemStack(Material.GOLD_INGOT);

        Configuration configuration = YamlConfiguration.loadConfiguration(new File("plugins//BedWars", "config.yml"));

        World world = Bukkit.getWorld(configuration.getString("gerador.world"));
        double x = configuration.getDouble("gerador.x");
        double y = configuration.getDouble("gerador.y");
        double z = configuration.getDouble("gerador.z");

        String cargo;

        if (event.getPlayer().isOp()) {
            cargo = "§4Admin";
        } else {
            cargo = "§ePlayer";
        }

        String formato = String.format("§3[%s§3]§7%s: §f%s", cargo, event.getPlayer().getName(), event.getMessage());

        event.setFormat(formato);
        Location location = new Location(world, x, y, z);

        teste(location, ferro, ouro);
    }

    private void teste(Location location, ItemStack ferro, ItemStack ouro) {
        final int[] contador = {0};

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("Gerando itens");
                Bukkit.getWorld(location.getWorld().getName()).dropItemNaturally(location, ferro);
                Bukkit.getWorld(location.getWorld().getName()).dropItemNaturally(location, ouro);

                if (contador[0] >= 10) {
                    Bukkit.broadcastMessage("Terminou");
                    this.cancel();
                }

                contador[0]++;
            }
        }.runTaskTimer(plugin, 20, 60);
    }

}
