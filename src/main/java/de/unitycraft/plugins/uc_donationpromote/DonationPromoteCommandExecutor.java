package de.unitycraft.plugins.uc_donationpromote;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Uwe Pfeifer on 26.01.14.
 */
public class DonationPromoteCommandExecutor implements CommandExecutor {

    private DonationPromote plugin; // pointer to your main class, unrequired if you don't need methods from the main class

    public DonationPromoteCommandExecutor(DonationPromote plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("donationpromote")) {
            if(!sender.hasPermission("donationpromote.command"))
            {
                sender.sendMessage("You don't have permission.");
            }
            if(args.length != 1) {
                // will auto give help :)
                return(false);
            }

            sender.sendMessage("Hope this is a player ...");

            return(true);

        }

        return(true);
    }

}
