package de.unitycraft.plugins.uc_donationpromote;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DonationPromote extends JavaPlugin {
    public void onDisable() {
        getLogger().info("DonationPromote v0.1 has been disabled.");
    }

    public void onEnable() {
        getLogger().info("DonationPromotion v0.1 has been loaded.");
        getCommand("donationpromote").setExecutor(new DonationPromoteCommandExecutor(this));
    }
}

