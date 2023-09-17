package uk.rythefirst.nihaess.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.milkbowl.vault.economy.Economy;
import uk.rythefirst.nihaess.Main;
import uk.rythefirst.nihaess.bounties.DataHandler;
import uk.rythefirst.nihaess.layouts.PlayerBounty;
import uk.rythefirst.nihaess.util.Chat;

public class PlayerDeath implements Listener {

	@EventHandler
	public void Pd(PlayerDeathEvent e) {

		if (e.getEntity().getKiller() != null && !(e.getEntity() == e.getEntity().getKiller())) {

			if (DataHandler.hasBounty(e.getEntity().getUniqueId())) {

				Economy eco = Main.getEconomy();

				PlayerBounty pb = DataHandler.getBounty(e.getEntity().getUniqueId());

				Double val = pb.getValue();

				eco.depositPlayer(e.getEntity().getKiller(), val);

				Chat.SendCenteredServerChat("The bounty on " + e.getEntity().getName() + " was claimed by: "
						+ e.getEntity().getKiller().getName());

				DataHandler.RemoveBounty(e.getEntity());

			}

		}

	}
}
