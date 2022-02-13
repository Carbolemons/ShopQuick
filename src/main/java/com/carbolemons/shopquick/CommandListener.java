package com.carbolemons.shopquick;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            switch (command.getName()) {
                case "reload":
                    player.sendMessage("Reloading Config.");
                    ShopQuick.plugin.loadConfig();
                    break;
                case "shop":
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', ShopQuick.plugin.config.getString("Flavor") + " " + ShopQuick.plugin.config.getString("ShopLink")));
                    break;
            }
        }
        return true;
    }
}
