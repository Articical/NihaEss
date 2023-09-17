package uk.rythefirst.nihaess.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.events.EntityDamageEntity;

public class Streamdmg implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender.hasPermission("niha.stream.toggle")) {
			
			EntityDamageEntity.ndamagedis = !(EntityDamageEntity.ndamagedis);
			
			sender.sendMessage(ChatColor.DARK_PURPLE + "Anti Stream Damage now set to " + EntityDamageEntity.ndamagedis);
			
		}
		
		return true;
		
	}
	
	

}
