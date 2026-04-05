package com.carrotguy69.ffb.cmd;

import com.carrotguy69.ffb.FakeFullbright;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static com.carrotguy69.ffb.FakeFullbright.f;

public class FFB implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("on")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1, false, false));
                p.sendMessage(f(FakeFullbright.enabledMessage));
            }
            else if (args[0].equalsIgnoreCase("off")) {
                p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                p.sendMessage(f(FakeFullbright.disabledMessage));
            }
            return true;
        }

        if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            // toggle off
            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
            p.sendMessage(f(FakeFullbright.disabledMessage));
        }

        else {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1, false, false));
            p.sendMessage(f(FakeFullbright.enabledMessage));
        }

        return true;
    }
}
