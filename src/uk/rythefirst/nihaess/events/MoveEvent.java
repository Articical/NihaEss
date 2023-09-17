package uk.rythefirst.nihaess.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.md_5.bungee.api.ChatColor;

public class MoveEvent implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld() == Bukkit.getWorld("world_nether")) {
			
			if(p.getPlayer().getLocation().getBlockY() > 127 && !(p.hasPermission("niha.nether"))) {
				p.sendMessage(ChatColor.DARK_RED + "Get off the top of the nether for goodness sake.");
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawn " + p.getName());
			}
		}
	}

}
