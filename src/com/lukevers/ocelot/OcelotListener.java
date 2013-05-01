package com.lukevers.ocelot;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OcelotListener implements Listener {
	
	private JavaPlugin plugin;
	
	public OcelotListener(JavaPlugin plugin) {
		this.plugin = plugin;
	} // close constructor
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		this.plugin.getConfig().set(event.getPlayer().getName()+".online", true);
		this.plugin.saveConfig();
	} // close on player login
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerLogout(PlayerQuitEvent event) {
		// On logging out, update all
		this.plugin.getConfig().set(event.getPlayer().getName()+".online", false);
		this.plugin.saveConfig();
	} // close on player logout
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerMove(PlayerMoveEvent event) {
		// On player move update location, food, and health
		updateLocation(event.getPlayer());
		updateFoodLevel(event.getPlayer());
		updateHealth(event.getPlayer());
	} // close on player move
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerLevelChange(PlayerLevelChangeEvent event) {
		// On level change, only update level change
		updateLevel(event.getPlayer());
	} // close on player move
	
	/**
	 * Update Location
	 * 
	 * Whenever a player moves, their location will
	 * be changed to the correct location.
	 * 
	 * @param player
	 */
	private void updateLocation(Player player) {
		this.plugin.getConfig().set(player.getName()+".location.x", player.getLocation().getX());
		this.plugin.getConfig().set(player.getName()+".location.y", player.getLocation().getY());
		this.plugin.getConfig().set(player.getName()+".location.z", player.getLocation().getZ());
		this.plugin.saveConfig();
	} // close update online status
	
	/**
	 * Update Level
	 * 
	 * Whenever a players level is changed, their
	 * level will be updated to the correct level.
	 *  
	 * @param player
	 */
	private void updateLevel(Player player) {
		this.plugin.getConfig().set(player.getName()+".level", player.getLevel());
		this.plugin.saveConfig();
	} // close update level
	
	/**
	 * Update Health
	 * 
	 * Whenever a players health changes, their
	 * health will be updated to the correct value.
	 * 
	 * @param player
	 */
	private void updateHealth(Player player) {
		this.plugin.getConfig().set(player.getName()+".health", player.getHealth());
		this.plugin.saveConfig();
	} // close update health
	
	/**
	 * Update Food Level
	 * 
	 * Whenever a players food level changes, their
	 * food level will be updated to the correct value.
	 * 
	 * @param player
	 */
	private void updateFoodLevel(Player player) {
		this.plugin.getConfig().set(player.getName()+".foodlevel", player.getFoodLevel());
		this.plugin.saveConfig();
	} // close update food level
	
} // close ocelot listener