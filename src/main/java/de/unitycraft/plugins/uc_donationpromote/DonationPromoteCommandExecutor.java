package de.unitycraft.plugins.uc_donationpromote;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Uwe Pfeifer on 26.01.14.
 */
public class DonationPromoteCommandExecutor implements CommandExecutor {

//    private DonationPromote plugin; // pointer to your main class, unrequired if you don't need methods from the main class

    public DonationPromoteCommandExecutor() {
        // Constructor with no arguments.
    }
//    public DonationPromoteCommandExecutor(DonationPromote plugin) {
//        this.plugin = plugin;
//    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Player player = (Player) sender;
        Player pToPromote;

        if (cmd.getName().equalsIgnoreCase("donationpromote")) {
            if (!sender.hasPermission("donationpromote.command")) {
                sender.sendMessage("You don't have permission.");
            }
//            if (sender instanceof Player) {
//                sender.sendMessage("This command can only be run by console.");
//            }
            if (args.length != 1) {
                sender.sendMessage("Wrong usage:");
                sender.sendMessage("/<command> <player>");
                return true;
            }

            // Only works when player is online.
            pToPromote = Bukkit.getServer().getPlayer(args[0]);
            if (pToPromote == null) {
                sender.sendMessage("The player " + args[0] + " is not online.");
                return true;
            }
            if (DonationPromote.perms.has(pToPromote, "group.builder")) {
                sender.sendMessage("Player is Builder. Promoting to Donator.");
                DonationPromote.perms.playerAddGroup(pToPromote, "Donator");
                DonationPromote.perms.playerRemoveGroup(pToPromote, "Builder");
                return true;
            } else if (DonationPromote.perms.has(pToPromote, "group.premium")) {
                sender.sendMessage("Player is Premium. Promoting to Dedicated.");
                DonationPromote.perms.playerAddGroup(pToPromote, "Dedicated");
                DonationPromote.perms.playerRemoveGroup(pToPromote, "Premium");
            } else {
                sender.sendMessage("Player is not Builder nor Premium, so not promoting/demoting.");
                return true;
            }

            return true;

        }

        return true;
    }

}
