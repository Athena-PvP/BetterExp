package com.kuriji.betterexp;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.kuriji.betterexp.event.block.BlockBreak;

public class BetterExp extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		registerEvents();
		registerConfig();

		logger.info(pdfFile.getName() + " has been enabled! (Version"
				+ pdfFile.getVersion() + ")");
	}

	

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + " has been disabled! (Version"
				+ pdfFile.getVersion() + ")");
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		PluginDescriptionFile pdfFile = getDescription();

		if (label.equalsIgnoreCase("BetterExp")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "You must be a player in order to execute this command.");
				return false;
			}
			Player player = (Player) sender;
			player.sendMessage(ChatColor.AQUA + "Version "
					+ pdfFile.getVersion());

			return true;
		}
		return false;
	}
	
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new BlockBreak(this), this);
	}
	
	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		
	}
}
