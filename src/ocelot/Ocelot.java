package ocelot;

import java.util.logging.Logger;

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
	
} // close class
