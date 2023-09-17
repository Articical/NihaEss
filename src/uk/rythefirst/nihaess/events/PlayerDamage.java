package uk.rythefirst.nihaess.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import uk.rythefirst.nihaess.Main;
import uk.rythefirst.nihaess.twitch.TwitchAPI;

public class PlayerDamage implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void dEvent(EntityDamageEvent e) {
		if(e.getEntityType() != EntityType.PLAYER) {
			return;
		}
		Player p = (Player) e.getEntity();
		Main.getTAPI();
		if(TwitchAPI.Live && p.getUniqueId().toString() == "b125bcb1-124b-457e-b8b0-15dfcbb23c0cK") {
			e.setCancelled(true);
		}
		
	}

}
