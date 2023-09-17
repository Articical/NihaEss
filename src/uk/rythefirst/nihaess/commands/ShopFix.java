package uk.rythefirst.nihaess.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import net.md_5.bungee.api.ChatColor;

public class ShopFix implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (args.length != 1) {
			sender.sendMessage(ChatColor.DARK_RED + "Usage: \"/shopfix <plotname>\"");
			return true;
		}

		if (args[0].contains("pshop")) {
			ConsoleCommandSender cs = Bukkit.getConsoleSender();

			String cmdstr = "rg flag " + args[0] + " ";

			Bukkit.dispatchCommand(cs, cmdstr + "-g OWNERS build allow");
			Bukkit.dispatchCommand(cs, cmdstr + "-g OWNERS chest-access allow");
			Bukkit.dispatchCommand(cs, cmdstr + "use allow");
			Bukkit.dispatchCommand(cs, cmdstr + "interact allow");
			Bukkit.dispatchCommand(cs, "rg setparent " + args[0] + " playermall");

			sender.sendMessage(ChatColor.GREEN + "Area " + args[0] + " fixed!");

			return true;

		} else {

			sender.sendMessage(ChatColor.DARK_RED + "Shop zones are in the following format \"pshop<number>\"");

			return true;

		}
	}

}
