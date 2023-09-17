package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.util.Messages;

public class ModHelp implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player p = (Player) sender;
		if(p.hasPermission("niha.mod")) {
			Messages.sendCenteredMessage(p,ChatColor.GOLD + "----- Moderator Help -----");
			p.sendMessage(ChatColor.GOLD + "/v - Vanish.");
			p.sendMessage(ChatColor.GOLD + "/aac moderator - Advanced anti cheat moderation menu.");
			p.sendMessage(ChatColor.GOLD + "/co inspect - CoreProtect block inspector.");
			p.sendMessage(ChatColor.GOLD + "/co rollback <time> - Roll back the area around you by the <time> specified (ex. 5m for 5 mins)");
			p.sendMessage(ChatColor.GOLD + "/back - returns you to your last location.");
			p.sendMessage(ChatColor.GOLD + "/feed - Feeds you (only permitted when on duty)");
			p.sendMessage(ChatColor.GOLD + "/fly - Enable or disable fly for yourself. (only permitted when on duty)");
			p.sendMessage(ChatColor.GOLD + "/gmsp - Set your gamemode to spectator. (only permitted when on duty)");
			p.sendMessage(ChatColor.GOLD + "/gms - Set your gamemode to survival.");
			p.sendMessage(ChatColor.GOLD + "/god - Give yourself god mode (only permitted when on duty)");
			p.sendMessage(ChatColor.GOLD + "/socialspy - Enable social spy (see messages between other players)");
			p.sendMessage(ChatColor.GOLD + "/tp <user> - force teleport to a user. (only permitted when on duty)");
			p.sendMessage(ChatColor.GOLD + "/punish <user> - Ban|Kick|Mute GUI");
			p.sendMessage(ChatColor.GOLD + "/clearchat - Clears the chat..");
			p.sendMessage(ChatColor.GOLD + "/lockdown - Locks the server down (only use this if something game-breaking occurs)");
			p.sendMessage(ChatColor.GOLD + "/togglechat - Toggle the chat on or off.");
			p.sendMessage(ChatColor.GOLD + "/(checkban|checkmute) <player> - Check if a player is banned or muted.");
			p.sendMessage(ChatColor.GOLD + "/history <player> - Check a users punishment history.");
			Messages.sendCenteredMessage(p,ChatColor.GOLD + "----- End of Help -----");
			return true;
		}
		return false;
	}

}
