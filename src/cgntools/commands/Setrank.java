package cgntools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionEntity;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Setrank implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setrank")) {
			if (args.length < 2) {
				sender.sendMessage("§6CGNTools§8:§c Correct usage: /setrank <nickname> <rank>");
			} else {
				if (sender.hasPermission("cgntools.setrank")) {
					Player player = Bukkit.getPlayer(args[0]);
					String rank = args[1];
					String group = PermissionsEx.getPermissionManager().getGroup(rank).getPrefix();
					if (player == null) {
						sender.sendMessage("§6CGNTools§8:§c The player is currently offline.");
						return false;
					}
					if (group.trim() == "") {
						sender.sendMessage("§6CGNTools§8:§c Such rank does not exist.");
						return false;
					}
					Bukkit.broadcastMessage("§6CGNTools§8:§7 "+player.getName()+"'s rank was set to "+rank+" by "+sender.getName()+".");
					PermissionGroup[] groups = PermissionsEx.getUser(player).getGroups();
					for (PermissionGroup crank : groups) {
						PermissionsEx.getUser(player).removeGroup(crank);
					}
					PermissionsEx.getUser(player).addGroup(rank);
					sender.sendMessage("§6*§7 The group list has been cleaned up. ");
				} else {
					sender.sendMessage("§6CGNTools§8:§c Sorry, your permission level is too low;");
				}
			}
		}
		return false;
	}

}
