package uk.rythefirst.nihaess.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class PlayerInteract implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void PlayerInteractE(PlayerInteractEvent e) {
		
		if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() == Material.PAPER && e.getPlayer().getItemInHand().hasItemMeta()) {
				ItemStack i = e.getPlayer().getItemInHand();
				ItemMeta im = i.getItemMeta();
				List<String> lore = im.getLore();
				if(lore.get(2).contains("1253325")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "holo setline Egg 1 &6&lOwned by: &d&l" + e.getPlayer().getName());
				}
			}
			
		}else if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType() == Material.PAPER && e.getPlayer().getItemInHand().hasItemMeta()) {
				ItemStack i = e.getPlayer().getItemInHand();
				ItemMeta im = i.getItemMeta();
				List<String> lore = im.getLore();
				if(lore.get(2).contains("1253325")) {
					String nom = e.getPlayer().getName();
					String newnom = ChatColor.MAGIC + "";
					for(int in=0;in<nom.length();in++) {
						newnom = newnom + "l";
					}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "holo setline Egg 1 &6&lOwned by: &d&l" + newnom);
				}
			}
			
		}
		
	}
	
}

