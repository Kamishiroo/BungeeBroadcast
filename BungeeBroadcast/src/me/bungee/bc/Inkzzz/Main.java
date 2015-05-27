package me.bungee.bc.Inkzzz;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	private static Main instance;
	
	public static Main getInstance() {
		return instance;
	}
	
	public void onEnable() {
		instance = this;
		getProxy().getPluginManager().registerCommand(this, new BroadcastCMD());
	}
	
}
