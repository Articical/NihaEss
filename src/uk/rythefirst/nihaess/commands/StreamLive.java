package uk.rythefirst.nihaess.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import uk.rythefirst.nihaess.twitch.TwitchAPI;
import uk.rythefirst.nihaess.util.Chat;
import uk.rythefirst.nihaess.util.Messages;

public class StreamLive implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		
		if(TwitchAPI.live() == true) {
			
			if(!(sender instanceof Player)) {
				sender.sendMessage(Chat.prefixFormatted + ChatColor.DARK_PURPLE + "Nihachu is live!");
				return true;
			}
			
			Player p = (Player) sender;
			
			Messages.sendCenteredMessage(p, "");
			Messages.sendCenteredMessage(p, "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "NihachuMC");
			Messages.sendCenteredMessage(p, "");
			Messages.sendCenteredMessage(p, ChatColor.DARK_PURPLE + "Nihachu is live!");
			Messages.sendCenteredMessage(p, ChatColor.DARK_PURPLE + "Watch: https://www.twitch.tv/nihachu");
			Messages.sendCenteredMessage(p, "");
			
		}else {
			
			if(!(sender instanceof Player)) {
			sender.sendMessage(Chat.prefixFormatted + ChatColor.DARK_PURPLE + "Nihachu is currently offline D:");
			return true;
			}
			
			Player p = (Player) sender;
			
			Messages.sendCenteredMessage(p, "");
			Messages.sendCenteredMessage(p, "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "NihachuMC");
			Messages.sendCenteredMessage(p, "");
			Messages.sendCenteredMessage(p, ChatColor.DARK_PURPLE + "Nihachu is Currently Offline D:");
			Messages.sendCenteredMessage(p, "");
		}
		
		return true;
	}

}
