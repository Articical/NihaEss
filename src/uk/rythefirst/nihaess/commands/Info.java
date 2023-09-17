package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Info implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		
		sender.sendMessage(ChatColor.GOLD + "----- Info list -----");
		sender.sendMessage(ChatColor.GOLD + "/shopinfo");
		sender.sendMessage(ChatColor.GOLD + "---- End of info -----");
			
		return true;
	}

}
