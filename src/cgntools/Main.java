package cgntools;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import cgntools.commands.Setrank;
import cgntools.events.CommandPreProcess;
import cgntools.events.PlayerJoin;
import cgntools.events.PlayerQuit;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		boolean mistake = 
				!getServer().getPluginManager().isPluginEnabled("PermissionsEx");
		if (mistake) {
			Bukkit.broadcastMessage("§6CGNTools§8:§c The plugin will be disabled, because there's no PermissionsEx or CGNChat plugin enabled.");
			System.err.println("The plugin CGNTools (Series CGN) requires the PermissionsEx and CGNChat plugin. The plugin will be disabled. Please make sure PEX and CGNC is installed before launching the plugin again;");
			getServer().getPluginManager().disablePlugin(this);
		} else {
			getCommand("setrank").setExecutor(new Setrank());
			getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
			getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
			getServer().getPluginManager().registerEvents(new CommandPreProcess(), this);
		}
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
