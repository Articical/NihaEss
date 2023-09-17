package uk.rythefirst.nihaess.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class dummys implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		ItemStack is = new ItemStack(Material.DIAMOND_SWORD, 1);

		ItemMeta im = is.getItemMeta();

		String name = ChatColor.translateAlternateColorCodes('&', "&4&lGod Sword");

		im.setDisplayName(name);

		im.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		im.addEnchant(Enchantment.DURABILITY, 5, true);
		im.addEnchant(Enchantment.FIRE_ASPECT, 1, true);

		List<String> l = new ArrayList<String>();

		l.add(ChatColor.GOLD + "Try it.");

		im.setLore(l);

		is.setItemMeta(im);

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (!(p.hasPermission("niha.admin"))) {
				return false;
			}

			p.getInventory().setItemInHand(is);
		}

		return false;
	}

}
