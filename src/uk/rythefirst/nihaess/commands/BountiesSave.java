package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.bounties.DataHandler;

public class BountiesSave implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		
		if(sender.hasPermission("niha.staff")) {
		
			DataHandler.saveBounties();
		
			sender.sendMessage(ChatColor.DARK_RED + "Bounties saved!");
			
		}
		
		return true;
		
	}

}
