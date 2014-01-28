package de.unitycraft.plugins.uc_donationpromote;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Uwe Pfeifer on 26.01.14.
 */
public class DonationPromoteCommandExecutor implements CommandExecutor {

    private DonationPromote plugin; // pointer to your main class, unrequired if you don't need methods from the main class

    public DonationPromoteCommandExecutor(DonationPromote plugin) {
        this.plugin = plugin;
    }

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
                // returning false will auto give help from plugin.yml :)
                return false;
            }
            if(args.length == 0) {
                return false;
            }

            // Only works when player is online.
            pToPromote = Bukkit.getServer().getPlayer(args[0]);
            if(pToPromote == null) {
                sender.sendMessage("The player " + args[0] + " is not online.");
                return true;
            }
            sender.sendMessage("Promoting player: " + args[0]);
            if (plugin.perms.has(pToPromote, "group.builder")) {
                sender.sendMessage("USer is Builder. Promoting to donator.");
            } else {
                sender.sendMessage("Another rank than builder ... just testing ...");
            }

            return true;

        }

        return true;
    }

}
