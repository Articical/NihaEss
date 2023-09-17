package uk.rythefirst.nihaess.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import uk.rythefirst.nihaess.Main;

public class Webmap implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Plugin pl = Main.instance;
		
		String url;
		
		Boolean type = pl.getConfig().getBoolean("subserver");
		
		if(type == true) {
			
			url = "http://submap.nihachumc.eu/";
			
		}else {
			
			url = "http://map.nihachumc.eu/";
			
		}
		
		sender.sendMessage(ChatColor.DARK_PURPLE + "The Dynmap can be found here: " + url);
		
		return true;
	}
	
	

}
