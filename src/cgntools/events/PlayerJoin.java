package cgntools.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage("§a§l+§f "+event.getPlayer().getDisplayName());
		if (!event.getPlayer().hasPlayedBefore()) {
			Player target = event.getPlayer();
			String[] welcome_lines = {
				  "&8###############################################",
				  "&6                        CGNCraft",
				  "&8                 Hello! / Cześć! / Hallo!",
				  "&7                   Welcome to CGNCraft ",
				  "&7       - An Advanced &csurvival &7server!",
		       "&a&l ○&7 Before you play on our server make sure, you",
		          "&7                  read our &c/rules&7!",
		          "",
		          "§7            Have a nice time playing here!",
		          "§6        ~ Tillthen [Server's main engineer]",
		          "&8###############################################",
			};
			for (String line : welcome_lines) {
				target.sendMessage(line.replaceAll("\\&", "§"));
			}
			Bukkit.broadcastMessage("§6CGNTools§8:§7 Say hello to "+target.getDisplayName()+"! He's the first time on the server!");
		}
	}
}
