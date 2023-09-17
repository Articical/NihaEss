package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.util.Messages;

public class Help implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		int page = 1;

		int pages = 4;

		if (!(sender instanceof Player)) {
			return false;
		}

		Player p = (Player) sender;

		Messages.sendCenteredMessage(p, "" + ChatColor.GOLD + ChatColor.BOLD + "----- Help -----");

		try {

			if (args.length == 0) {

				page = 1;

			} else {

				if (page <= pages) {

					page = Integer.parseInt(args[0]);

				}

			}

		} catch (Exception e) {

			page = 1;

		}

		if (page == 1) {

			if (p.hasPermission("niha.mod")) {
				p.sendMessage(ChatColor.GOLD + "For the moderator commands, please use /modhelp");
			}
			p.sendMessage(ChatColor.GOLD + "/help <number> - View the other help pages.");
			p.sendMessage(ChatColor.GOLD + "/tpa <user> - Request to teleport to a player.");
			p.sendMessage(ChatColor.GOLD + "/vault <number> - Access a private vault (sub / booster / dono)");
			p.sendMessage(ChatColor.GOLD + "/back - Return to your previous location after teleporting.");
			p.sendMessage(ChatColor.GOLD + "/pt - Show your own playtime.");
			p.sendMessage(ChatColor.GOLD + "/pt <player> - Show another players playtime.");
			p.sendMessage(ChatColor.GOLD + "/sethome <name> - Set a home, max of 5 by default (10 for mods)");
			p.sendMessage(ChatColor.GOLD + "/home <name> - teleport to your home.");
			p.sendMessage(ChatColor.GOLD + "/ah - Opens the auction house.");
			p.sendMessage(ChatColor.GOLD + "/bal - Shows your balance.");
			Messages.sendCenteredMessage(p, ChatColor.GOLD + "----- Page 1 of 3 -----");

		} else if (page == 2) {

			p.sendMessage(ChatColor.GOLD + "/website - Get a link to the server's website.");
			p.sendMessage(ChatColor.GOLD + "/discord link - Link discord and minecraft (sub/booster)");
			p.sendMessage(ChatColor.GOLD + "/webmap - Provides the Dynmap link.");
			p.sendMessage(ChatColor.GOLD + "/baltop - Shows the balance leader board.");
			p.sendMessage(ChatColor.GOLD + "/m <user> <message> - Message a user.");
			p.sendMessage(ChatColor.GOLD + "/spawn - Teleport to the spawn.");
			p.sendMessage(ChatColor.GOLD + "/warp shop - Teleport to the server shop.");
			p.sendMessage(ChatColor.GOLD + "/time - Check the in-game time.");
			p.sendMessage(ChatColor.GOLD + "/pinfo - Get information about game mechanics.");
			p.sendMessage(ChatColor.GOLD + "/bounties - Open the bounties GUI.");
			Messages.sendCenteredMessage(p, ChatColor.GOLD + "----- Page 2 of 3 -----");

		} else if (page == 3) {

			p.sendMessage(ChatColor.GOLD + "/setbounty <player> <amount> - Set a bounty on a player.");
			p.sendMessage(ChatColor.GOLD + "/live - Check if Niki is live.");
			p.sendMessage(ChatColor.GOLD + "/twitch <channel> - Check if a channel is live (defaults to niki)");
			p.sendMessage(ChatColor.GOLD + "/togglemention - Enable/Disable audio alerts for mentions.");
			p.sendMessage(ChatColor.GOLD + "/sellxp <amount> - Trade XP for money!");
			p.sendMessage(ChatColor.GOLD + "/reservedslots - Check how many slots are reserved.");
			p.sendMessage(ChatColor.GOLD + "/kit claims - Get a golden shovel for claiming.");
			p.sendMessage(ChatColor.GOLD + "/trust <player> - Trust a player in your claim.");
			p.sendMessage(ChatColor.GOLD + "/untrust <player> - Untrust a player in your claim.");
			p.sendMessage(ChatColor.GOLD + "/abandonclaim - Abandon a claim.");
			Messages.sendCenteredMessage(p, ChatColor.GOLD + "----- Page 3 of 4 -----");

		} else if (page == 3) {

			p.sendMessage(ChatColor.GOLD + "/sellxp <amount> - Exchange XP for money.");
			p.sendMessage(ChatColor.GOLD + "/live - Check if Niki is live.");
			Messages.sendCenteredMessage(p, ChatColor.GOLD + "----- Page 3 of 4 -----");

		}

		return true;
	}

}
