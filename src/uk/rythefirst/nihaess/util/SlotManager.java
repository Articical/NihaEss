package uk.rythefirst.nihaess.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SlotManager {
	
	private static List<String> usingslots = new ArrayList<String>();
	
	public static Integer UsedSlotCount() {
		
		return usingslots.size();
		
	}
	
	public static String users() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<usingslots.size();i++) {
			UUID id = UUID.fromString(usingslots.get(i));
			Player p = Bukkit.getPlayer(id);
			if(!((i+1) == usingslots.size())) {
				sb.append(p.getName() + ", ");
			}else {
				sb.append(p.getName());
			}
		}
		
		return sb.toString();
		
	}
	
	public static Boolean remove(UUID id) {
		
		if(usingslots.contains(id.toString())) {
			
			usingslots.remove(id.toString());
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static Boolean useSlot(UUID id) {
		
		if(!(usingslots.contains(id.toString()))) {
			
			usingslots.add(id.toString());
			
			return true;
			
		}
		
		return false;
		
	}

}
