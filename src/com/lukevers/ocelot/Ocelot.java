package com.lukevers.ocelot;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Ocelot extends JavaPlugin {
	
	private Logger log = Logger.getLogger("Minecraft");
	private String Version;

	@Override 
	public void onEnable() {
		log.info("Ocelot "+Version+" enabled");
	} // close on enable
	
	@Override
	public void onDisable() {
		log.info("Ocelot "+Version+" disabled");
	} // close on disable
	
	@EventHandler  (priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		updateConfig(event.getPlayer());
	} // close on player login
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerLogout(PlayerQuitEvent event) {
		updateConfig(event.getPlayer());
	} // close on player logout
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerMove(PlayerMoveEvent event) {
		updateConfig(event.getPlayer());
	} // close on player move

	/**
	 * Update Configuration File
	 * 
	 * Whenever updateConfig(Player player) is called
	 * the configuration file will be updated with all
	 * the desired information.
	 * 
	 * WHAT WE GENERALLY WANT IN THE CONFIGURATION FILE
	 * 
	 * 1. Is the player online? {{boolean}} (true:yes|false:no)
	 * 2. What's the player's health? {{int}}
	 * 3. What's the player's food level? {{int}}
	 * 4. What's the player's level? {{int}}
	 * 5. What is the player's location? {{Location}}
	 * 
	 * @param player
	 */
	private void updateConfig(Player player) {
		// Get the player name
		String name = player.getName();
		
		// Set variables to be updated
		boolean online = player.isOnline();
		int health = player.getHealth();
		int food = player.getFoodLevel();
		int level = player.getLevel();
		Location loc = player.getLocation();
		
		// Set the configuration file variables
		getConfig().set(name+".online", online);
		getConfig().set(name+".health", health);
		getConfig().set(name+".foodlevel", food);
		getConfig().set(name+".level", level);
		getConfig().set(name+".location.x", loc.getX());
		getConfig().set(name+".location.y", loc.getY());
		getConfig().set(name+".location.z", loc.getZ());
	} // close update configuration file
	
	
} // close class
