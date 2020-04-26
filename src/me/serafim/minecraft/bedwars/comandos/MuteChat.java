package me.serafim.minecraft.bedwars.comandos;

import me.serafim.minecraft.bedwars.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteChat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;

        if (player.isOp()) {

            if (Plugin.chat) {
                Bukkit.broadcastMessage("§cChat foi Desmutado");
                Plugin.chat = false;
            } else {
                Plugin.chat = true;
                Bukkit.broadcastMessage("§cChat foi mutado");
            }

        } else {
            player.sendMessage("§cSem permissão");
        }

        return false;
    }
}
