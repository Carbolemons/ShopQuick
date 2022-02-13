package com.carbolemons.shopquick;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/*
   _____ _                  ____        _      _
  / ____| |                / __ \      (_)    | |
 | (___ | |__   ___  _ __ | |  | |_   _ _  ___| | __
  \___ \| '_ \ / _ \| '_ \| |  | | | | | |/ __| |/ /
  ____) | | | | (_) | |_) | |__| | |_| | | (__|   <
 |_____/|_| |_|\___/| .__/ \___\_\\__,_|_|\___|_|\_\
                    | |
                    |_|

 * ShopQuick - Shop link for Bukkit and forks of Bukkit.
 * Copyright (C) 2022 Carbolemons / Lee C.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

public final class ShopQuick extends JavaPlugin {

    public static ShopQuick plugin;

    private File configfile = new File(getDataFolder(), "config.yml");
    public FileConfiguration config = this.getConfig();

    public void loadConfig() {

        if(!configfile.exists()) {
            getLogger().info("Creating new Config.yml");
            configfile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }
        config = new YamlConfiguration();
        try {
            config.load(configfile);
        } catch(IOException | InvalidConfigurationException e) {
            getLogger().info("Error Creating Config.yml");
            e.printStackTrace();
        }
    }

    private void registerCommands() {
        this.getCommand("shop").setExecutor(new CommandListener());
        this.getCommand("reload").setExecutor(new CommandListener());
    }

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("Enabled Successfully.");
        loadConfig();
        registerCommands();
    }
    @Override
    public void onDisable() {
        getLogger().info("Disabled Successfully.");
    }

}
