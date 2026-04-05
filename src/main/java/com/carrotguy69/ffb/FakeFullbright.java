package com.carrotguy69.ffb;

import com.carrotguy69.ffb.cmd.FFB;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public final class FakeFullbright extends JavaPlugin {

    public JavaPlugin plugin = null;
    public static String enabledMessage;
    public static String disabledMessage;

    @Override
    public void onEnable() {

        plugin = JavaPlugin.getPlugin(FakeFullbright.class);

        saveDefaultConfig();
        reloadConfig();

        getConfig().options().copyDefaults(true);

        saveConfig();

        enabledMessage = plugin.getConfig().getString("messages.ffb-enabled", "&aFullbright enabled!");
        disabledMessage = plugin.getConfig().getString("messages.ffb-disabled", "&aFullbright disabled!");


        Objects.requireNonNull(Bukkit.getPluginCommand("ffb")).setExecutor(new FFB());
        Objects.requireNonNull(Bukkit.getPluginCommand("ffb")).setTabCompleter(new com.carrotguy69.ffb.tabCompleters.FFB());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static String f(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
