package uk.rythefirst.nihaess.events;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.Main;
import uk.rythefirst.nihaess.layouts.ChatWord;
import uk.rythefirst.nihaess.util.MentionHandler;
import uk.rythefirst.nihaess.util.Messages;

public class ChatEvent implements Listener{
	
	public HashMap<Player,Long> pmap = new HashMap<Player,Long>();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerChatEvent(AsyncPlayerChatEvent e) {
		
		if(Main.mfilter.IsUrlMatch(e.getMessage()) && !(e.getPlayer().hasPermission("niha.chat.bypass"))){
			
			e.getPlayer().sendMessage(ChatColor.DARK_RED + "Urls are not permitted.");
			e.setCancelled(true);
			
		}
		
		if(Main.getCwg().isOnGoing()) {
			ChatWord word = Main.getCwg().getWord();
			
			if(e.getMessage().equalsIgnoreCase(word.getWord())) {
				word.setGuessed(true);
				Main.getCwg().setOnGoing(false);
				for(Player p : Bukkit.getOnlinePlayers()) {
					p.playSound(p.getLocation(), Sound.ITEM_SHIELD_BLOCK, 1f, 1f);
					Messages.sendCenteredMessage(p, "" + ChatColor.GOLD + ChatColor.UNDERLINE + "Speed Typer");
					Messages.sendCenteredMessage(p, ChatColor.GOLD + "Game over!");
					Messages.sendCenteredMessage(p, ChatColor.GOLD + e.getPlayer().getName() + " typed the word first!");
					if(p == e.getPlayer()) {
						Messages.sendCenteredMessage(p, ChatColor.GOLD + "You won $5000");
						Main.getEconomy().depositPlayer(e.getPlayer(), 5000d);
					}else {
						Messages.sendCenteredMessage(p, "");
					}
				}
				
				Bukkit.getLogger().log(Level.INFO,"[NihaESS] " + e.getPlayer().getName() + " Guessed the word!");
			}
			
		}
				
		String name = e.getMessage().toLowerCase();	
		
		long ms = System.currentTimeMillis();	
		
		for(Player p : Bukkit.getServer().getOnlinePlayers()) {	
			
			if(name.contains(p.getName().toLowerCase()) && !(p.getName() == e.getPlayer().getName())) {	
				
				if(pmap.containsKey(p) && !(e.getPlayer().hasPermission("niha.mention.staff"))) {		
					Long oldval = pmap.get(p);
					oldval = oldval + 30000;
					
					if(!(ms > (oldval))) {
						//e.getPlayer().sendMessage(ChatColor.DARK_RED + "You can't mention that player yet!");
						return;
					}else {		
						pmap.remove(p);		
					}
				}
				
				if(MentionHandler.ismuted(p) && !(e.getPlayer().hasPermission("niha.mention.staff"))) {
					return;
				}
				
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1f, 1f);	
				pmap.put(p, System.currentTimeMillis());	
			}
					
		}
		
	}

}
