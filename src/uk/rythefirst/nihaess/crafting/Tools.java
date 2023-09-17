package uk.rythefirst.nihaess.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import uk.rythefirst.nihaess.Main;

public class Tools {
	
	public static ShapedRecipe emeraldSword() {
		
		Plugin pl = Main.instance;
		
		NamespacedKey key = new NamespacedKey(pl, "emerald_sword");
		
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD,1);
		
		Damageable im = (Damageable) item.getItemMeta();
		
		im.setDamage(item.getType().getMaxDurability() / 2);
		
		ItemMeta meta = (ItemMeta) im;
		
		meta.setDisplayName(ChatColor.GREEN + "Emerald Pickaxe");
		
		item.setItemMeta(meta);
		
		ShapedRecipe esr = new ShapedRecipe(key,item);
		
		esr.shape(" E ", " E ", " S ");
		
		esr.setIngredient('E', Material.EMERALD);
		esr.setIngredient('S', Material.STICK);
		
		return esr;
	}

}
