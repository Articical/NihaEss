package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.Main;
import uk.rythefirst.nihaess.util.SlotManager;

public class Reservedslots implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		sender.sendMessage(ChatColor.GOLD + "Reserved slots: " + SlotManager.UsedSlotCount() + " used, max: " + Main.getResSlots());
		
		
		sender.sendMessage(ChatColor.GOLD + "Players using reserved slots: " + SlotManager.users());
		
		return true;
	}
	
	

}
