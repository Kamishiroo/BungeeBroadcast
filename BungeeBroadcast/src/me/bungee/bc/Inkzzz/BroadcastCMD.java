package me.bungee.bc.Inkzzz;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BroadcastCMD extends Command {

	private static final String perm = "bungee.broadcast";

	public BroadcastCMD() {
		super("an", null);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission(perm)) {
			p.sendMessage(color("&cPermission> &7Sorry, but you have insufficient permissions."));
			return;
		}
		if (args.length < 1) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&cUsage> &7/an <message>"));
			return;
		} else {
			for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers()) {
				on.sendMessage(color("&c&m============&r &f&l&oAnnoucement &c&m============"));
				on.sendMessage(" ");
				on.sendMessage(color("&7> &e" + getMessage(args)));
				on.sendMessage(" ");
				on.sendMessage(color("&c&m====================================="));
			}
			return;
		}
	}

	private String getMessage(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i]).append(" ");
		}
		return sb.toString();
	}

	private String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

}
