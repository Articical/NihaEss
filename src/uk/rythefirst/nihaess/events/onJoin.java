package uk.rythefirst.nihaess.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.Main;
import uk.rythefirst.nihaess.util.SlotManager;

public class onJoin implements Listener{
	
	public static List<String> plist = Main.instance.getConfig().getStringList("players");
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerJoinedEvent(PlayerLoginEvent e) {
		
		//UUID nikiID = UUID.fromString("b125bcb1124b457eb8b015dfcbb23c0c");
		
		/*if(p.getName().toLowerCase() == "nihachu" && !(plist.contains(p.getUniqueId().toString()))) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set group.niki");
		}*/
		
		/*if((!(plist.contains(e.getPlayer().getUniqueId().toString())))) {
			
			plist.add(e.getPlayer().getUniqueId().toString());
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn " + p.getName());
			
		}*/
		
		if(e.getPlayer().hasPermission("niha.slot") && !(SlotManager.UsedSlotCount() == Main.getResSlots())) {
			
			SlotManager.useSlot(e.getPlayer().getUniqueId());
			
		}else {
			
			int MaxSlots = Bukkit.getServer().getMaxPlayers();
			
			int usedslots = SlotManager.UsedSlotCount();
			
			int MaxUsableSlots = MaxSlots - Main.getResSlots();
			
			int usednoperm = MaxUsableSlots - (Bukkit.getServer().getOnlinePlayers().size() - usedslots);
			
			if(usednoperm == 0) {
				
				e.disallow(Result.KICK_FULL, ChatColor.DARK_RED + "Only reserved slots are left.");
				
			}
			
		}
		
		
	}

}
