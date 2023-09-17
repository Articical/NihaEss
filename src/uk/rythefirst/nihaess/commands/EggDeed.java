package uk.rythefirst.nihaess.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class EggDeed implements CommandExecutor {

	public ItemStack item() {
		ItemStack is = new ItemStack(Material.PAPER, 1);

		ItemMeta im = is.getItemMeta();

		im.setDisplayName("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Dragon Egg Deed");

		List<String> lorels = new ArrayList<String>();

		lorels.add(ChatColor.DARK_AQUA + "Left click this item to claim the Egg.");
		lorels.add(ChatColor.DARK_AQUA + "Right click to claim anonymously.");
		lorels.add("1253325");

		im.setLore(lorels);

		is.setItemMeta(im);

		return is;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {

			Player p = (Player) sender;

			if (p.hasPermission("niha.admin")) {
				p.setItemInHand(item());
			}

		}

		return true;

	}

}
