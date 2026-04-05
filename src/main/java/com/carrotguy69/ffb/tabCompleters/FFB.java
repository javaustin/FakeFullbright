package com.carrotguy69.ffb.tabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class FFB implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> options = List.of("on", "off");
        List<String> results = new ArrayList<>();

        if (args.length == 1) {
            for (String option : options) {
                if (option.startsWith(args[0])) {
                    results.add(option);
                }

            }

        }

        return results;
    }
}
