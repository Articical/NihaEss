package uk.rythefirst.nihaess.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import uk.rythefirst.nihaess.util.SlotManager;

public class Leave implements Listener {

	@EventHandler
	public void playerLeave(PlayerQuitEvent e) {

		// DataHandler.RemoveBounty(e.getPlayer());

		Player p = e.getPlayer();

		if (p.hasPermission("niha.slot")) {

			SlotManager.remove(p.getUniqueId());

			return;

		}

	}

}
