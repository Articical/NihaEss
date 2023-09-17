package uk.rythefirst.nihaess.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.util.Messages;

public class Plugins implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerCommand(PlayerCommandPreprocessEvent e) {
		
		String cmd = e.getMessage();
		
		String[] lst = cmd.split(" ");
		
		if(lst[0].contains("plugins")) {
			
			Messages.sendCenteredMessage(e.getPlayer(), ChatColor.DARK_RED + "Nice try.");
			
			e.setCancelled(true);
		}
		
	}

}
