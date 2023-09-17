package uk.rythefirst.nihaess.util;

import java.util.logging.Level;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;
import uk.rythefirst.nihaess.Main;

public class Restarts {
	
	public static int c2 = 0;
	
	public static int counter = 0;
	
	public static void starttimer(){

			Bukkit.getScheduler().runTaskTimer(Main.instance, new Runnable() {
			
			@Override
			public void run() {
				
				counter = counter + 1;
				
				int left = 12 - counter;
				
				Bukkit.getLogger().log(Level.INFO, "Restart due in " + left + " hours");
				
				if(left <= 6 && !(left == 0)) {
					
					Chat.SendCenteredServerChat(ChatColor.DARK_PURPLE + "Server restart in " + left + " hours");
					
				}else if(left == 0) {
					
					Bukkit.getScheduler().runTaskTimer(Main.instance, new Runnable() {

						@Override
						public void run() {
							
							c2++;
							
							if(c2 == 1) {
								
								Chat.SendCenteredServerChat(ChatColor.DARK_PURPLE + "Server restart in: " + 30 + " Seconds!");
								
							}else if(c2 == 2) {
								
								Chat.SendCenteredServerChat(ChatColor.DARK_PURPLE + "Server restart in: " + 20 + " Seconds!");
								
							}else if(c2 == 3) {
								
								Chat.SendCenteredServerChat(ChatColor.DARK_PURPLE + "Server restart in: " + 10 + " Seconds!");
								
							}else if(c2 == 2) {
								
								Chat.SendCenteredServerChat(ChatColor.DARK_PURPLE + "Server restarting!");
								
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
								
							}
							
						}
						
						
						
					}, 0l, 200);
					
				}
				
			}
			
		}, 0l, 72000l);
		
	}

}
