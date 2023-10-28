package net.ddns.vcccd;

import org.bukkit.ChatColor;
import org.bukkit.Nameable;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventHandlerClass implements Listener{
	
	@EventHandler
	public void ThisNameDoesentMatter(EntityDamageByEntityEvent event){
		
		//Checks to see if the entity was attacked by a player
		if(event.getDamager() instanceof Player) {
			
			//If so, we track the Entity through its Damage and Name class
			//To get the Health of the Entity and changes its name
			Damageable entity = (Damageable) event.getEntity();
			Nameable ref_ent = (Nameable) event.getEntity();
			
			//We Then set its name to the amount of hearts it has
			ref_ent.setCustomName(hearts(entity.getHealth()));
		}
	}
	
	//This is a custom function that uses an Accumulator for heart keys 
	public String hearts(double parameter) {
		
		//Init the Accumulator
		String Accum = "";
		
		//For loop to iterate through the amount of hearts the entity has
		for(int heart = 0; heart < parameter-1; heart++) {
			
			//Pushes the heart into the Accumulator
			Accum = Accum + ChatColor.translateAlternateColorCodes('&', "&c&l♡");
		}
		
		//Returns the string
		return(Accum);
	}

}
