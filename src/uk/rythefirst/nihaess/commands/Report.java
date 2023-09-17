package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Report implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		sender.sendMessage(ChatColor.DARK_PURPLE + "Nihachu" + ChatColor.GOLD + "MC" + ChatColor.WHITE
				+ ": If you need to report someone, please contact any moderators currently on the server or send a DM to RyTheFirst#0001 on discord!");

		return false;
	}

}
