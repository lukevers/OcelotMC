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

public class OcelotListener extends JavaPlugin implements Listener {
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		// On logging in, update all
		updateOnlineStatus(event.getPlayer());
		updateLocation(event.getPlayer());
		updateFoodLevel(event.getPlayer());
		updateHealth(event.getPlayer());
		updateLevel(event.getPlayer());
	} // close on player login
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerLogout(PlayerQuitEvent event) {
		// On logging out, update all
		updateOnlineStatus(event.getPlayer());
		updateLocation(event.getPlayer());
		updateFoodLevel(event.getPlayer());
		updateHealth(event.getPlayer());
		updateLevel(event.getPlayer());
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
		this.getConfig().set(player.getName()+".location.x", player.getLocation().getX());
		this.getConfig().set(player.getName()+".location.y", player.getLocation().getY());
		this.getConfig().set(player.getName()+".location.z", player.getLocation().getZ());
		this.saveConfig();
	} // close update online status
	
	/**
	 * Update Online Status
	 * 
	 * Whenever a player either logs in or logs out,
	 * their online status will be updated to the correct value.
	 * 
	 * @param player
	 */
	private void updateOnlineStatus(Player player) {
		this.getConfig().set(player.getName()+".online", player.isOnline());
		this.saveConfig();
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
		this.getConfig().set(player.getName()+".level", player.getLevel());
		this.saveConfig();
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
		this.getConfig().set(player.getName()+".level", player.getHealth());
		this.saveConfig();
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
		this.getConfig().set(player.getName()+".level", player.getFoodLevel());
		this.saveConfig();
	} // close update food level
	
} // close ocelot listener