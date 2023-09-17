package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class ShopInfo implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		sender.sendMessage("Shops");
		sender.sendMessage(ChatColor.GOLD + "----- Player shop info -----");
		sender.sendMessage(ChatColor.GOLD + "Place a chest, with the items and amount you want to sell inside (this can be placed anywhere)");
		sender.sendMessage(ChatColor.GOLD + "Place a sign where you want people to purchase the items.");
		sender.sendMessage(ChatColor.GOLD + "Format the sign as the following:");
		sender.sendMessage(ChatColor.GOLD + "Line 1: [Buy]");
		sender.sendMessage(ChatColor.GOLD + "Lines 2/3 can say anything (suggest the items you're selling)");
		sender.sendMessage(ChatColor.GOLD + "Line 4: $<cost>");
		sender.sendMessage(ChatColor.GOLD + "Left click on the chest, then the sign with a piece of redstone.");
		sender.sendMessage(ChatColor.GOLD + "Your shop is now active! You can fill the chest!");
		sender.sendMessage(ChatColor.GOLD + "");
		sender.sendMessage(ChatColor.GOLD + "In order to make a shop where people can sell to you, replace [Buy] with [Sell]");
		return true;
	}

}
