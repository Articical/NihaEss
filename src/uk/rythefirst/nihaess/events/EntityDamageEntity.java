package uk.rythefirst.nihaess.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EntityDamageEntity implements Listener {

	public static boolean ndamagedis = true;

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void EntityD(EntityDamageByEntityEvent e) {

		if (e.getEntityType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.PLAYER) {

			if (!(e.getDamager().hasPermission("niha.staff"))) {
				Player Damager = (Player) e.getDamager();
				if (Damager.getItemInHand() != null) {
					ItemStack is = Damager.getItemInHand();
					ItemMeta im = is.getItemMeta();
					if ((!(im == null)) && im.hasLore() && im.getLore().get(0).contains("Try it.")) {
						e.setCancelled(true);
					}
				}
			}

			if (e.getDamager() instanceof Player) {
				Player dmger = (Player) e.getDamager();
				if (dmger.getItemInHand() != null) {
					ItemStack is = dmger.getItemInHand();
					ItemMeta im = is.getItemMeta();
					if ((!(im == null)) && im.hasLore() && im.getLore().get(0).contains("BAN THEM.")) {
						if (e.getDamager().hasPermission("niha.staff.bsword")) {
							Bukkit.dispatchCommand(dmger,
									"ban " + e.getEntity().getName() + " The Ban Sword Has Spoken.");
						}
						e.setCancelled(true);
					}
				}
			}

		}
	}

}
