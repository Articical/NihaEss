package uk.rythefirst.nihaess.commands;

import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import uk.rythefirst.nihaess.Main;

public class RussianRoulette implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		
		Economy economy = Main.getEconomy();
		
		Random rand = new Random();
		
		int num = rand.nextInt(60);
		
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player p = (Player) sender;
		
		if(economy.getBalance(p) < 1000) {
			p.sendMessage(ChatColor.GOLD + "That costs $1000, you're poor.");
			return true;
		}
		
		if(num<40) {
			economy.withdrawPlayer(p, 1000);
			p.sendMessage(ChatColor.DARK_RED + "You died...");
			p.setHealth(0);
			//Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.DARK_RED + ChatColor.BOLD + " took their own life playing Russian roulette... They also lost $1000 just to rub salt in the wound ;)");
		}else {
			p.sendMessage("" + ChatColor.GOLD + ChatColor.BOLD + "You survived and won $10000");
			economy.depositPlayer(p, 10000);
		}
		
		return true;
	}

}
