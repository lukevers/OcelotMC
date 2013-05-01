package ocelot;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
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
	
	@EventHandler 
	public void onPlayerLogin(PlayerLoginEvent event) {
		if (this.getConfig().getString(event.getPlayer().getName()).equals(null)) {
			setDefaults(event.getPlayer());
		} else updateConfig(event.getPlayer());
	} // close on player login
	
	@EventHandler
	public void onPlayerLogout(PlayerQuitEvent event) {
		
	} // close on player logout
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		updateConfig(event.getPlayer());
	} // close on player move
	
	/**
	 * Set Defaults
	 * 
	 * If a player is not in the current configuration
	 * file then we need to add that player to the file.
	 * 
	 * @param player
	 */
	private void setDefaults(Player player) {
		
	} // close set defaults
	
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
	 * 3. What is the player's location? {{Location}}
	 * 4. What's the player's hunger? {{int}}
	 * 5. What's the player's level? {{int}}
	 * 
	 * @param player
	 */
	private void updateConfig(Player player) {
		
	} // close update configuration file
	
	
} // close class
