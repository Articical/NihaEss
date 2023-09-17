package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.layouts.TwitchInfo;
import uk.rythefirst.nihaess.twitch.TwitchAPI;
import uk.rythefirst.nihaess.util.Messages;

public class StreamInfo implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player p = (Player) sender;
		
		if(TwitchAPI.live() == true) {
			
			TwitchInfo info = TwitchAPI.info;
		
			Messages.sendCenteredMessage(p, "");
			Messages.sendCenteredMessage(p, "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "NihachuMC");
			Messages.sendCenteredMessage(p, "");
			Messages.sendCenteredMessage(p, ChatColor.DARK_PURPLE + "Nihachu is live!");
			Messages.sendCenteredMessage(p, ChatColor.DARK_PURPLE + "@ https://www.twitch.tv/nihachu");
			Messages.sendCenteredMessage(p, ChatColor.DARK_PURPLE + "Playing: " + info.getGame());
			Messages.sendCenteredMessage(p, ChatColor.DARK_PURPLE + "With " + info.getViewerCount() + " Viewers!");
			Messages.sendCenteredMessage(p, "");
		
		}else {
			
			Messages.sendCenteredMessage(p, "");
			Messages.sendCenteredMessage(p, "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "NihachuMC");
			Messages.sendCenteredMessage(p, "");
			Messages.sendCenteredMessage(p, ChatColor.DARK_PURPLE + "Nihachu is currently offline!");
			Messages.sendCenteredMessage(p, "");
			
		}
		
		return true;
	}

}
