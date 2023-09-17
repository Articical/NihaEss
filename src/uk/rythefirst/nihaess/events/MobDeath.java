package uk.rythefirst.nihaess.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

public class MobDeath implements Listener {

	Random rand = new Random();

	public Boolean doDrop() {
		int i = rand.nextInt(100);
		if (i <= 20) {
			return true;
		} else {
			return false;
		}
	}

	@EventHandler
	public void MobDeathEvent(EntityDeathEvent e) {
		LivingEntity ent = e.getEntity();
		if (ent.getType() == EntityType.SKELETON && doDrop() && e.getEntity().getKiller() != null) {
			ItemStack i = new ItemStack(Material.SKELETON_SKULL, 1);
			e.getDrops().add(i);
		}

		if (ent.getType() == EntityType.ZOMBIE && doDrop() && e.getEntity().getKiller() != null) {
			ItemStack i = new ItemStack(Material.ZOMBIE_HEAD, 1);
			e.getDrops().add(i);
		}

		if (ent.getType() == EntityType.CREEPER && doDrop() && e.getEntity().getKiller() != null) {
			ItemStack i = new ItemStack(Material.CREEPER_HEAD);
			e.getDrops().add(i);
		}

		if (ent.getType() == EntityType.PLAYER && e.getEntity().getKiller() != null) {

			Player p = (Player) ent;
			ItemStack is = new ItemStack(Material.PLAYER_HEAD);

			SkullMeta meta = (SkullMeta) is.getItemMeta();

			meta.setOwningPlayer(p);
			meta.setDisplayName(ChatColor.GOLD + p.getName() + "'s head");

			is.setItemMeta(meta);

			if (ent.getKiller() != null) {
				e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), is);
			}
		}

		if (ent.getType() == EntityType.PLAYER && e.getEntity().getKiller() != null) {
			Player p = (Player) ent;

			Player pl = Bukkit.getPlayerExact("RyTheFirst");

			if (p == pl) {
				ItemStack is = new ItemStack(Material.DIAMOND_HOE, 1);
				ItemMeta im = is.getItemMeta();
				im.setDisplayName("" + ChatColor.BOLD + ChatColor.DARK_PURPLE + "Ry's Main Hoe");

				List<String> l = new ArrayList<String>();

				l.add(ChatColor.DARK_RED + "Hoe'd");
				im.setLore(l);
				im.addEnchant(Enchantment.DAMAGE_ALL, 5, true);

				is.setItemMeta(im);

				int i = rand.nextInt(100);
				if (i <= 7) {
					e.getDrops().add(is);
				}
			}
		}

	}

}
