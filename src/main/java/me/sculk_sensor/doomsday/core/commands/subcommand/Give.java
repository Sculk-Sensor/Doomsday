package me.sculk_sensor.doomsday.core.commands.subcommand;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.MainCommand;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import me.sculk_sensor.doomsday.api.mechanism.CoordinateSystemType;
import me.sculk_sensor.doomsday.core.commands.DoomsdayCommand;
import me.sculk_sensor.doomsday.core.registry.DoomsdayRegistry;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.List;

public class Give extends SubCommand {
	public Give(Doomsday plugin, DoomsdayCommand mainCommand, String name, boolean hidden, SubCommand... subCommands) {
		super(plugin, mainCommand, name, hidden, subCommands);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		for (String s : args) {
			sender.sendMessage(s);
		}
		sender.sendMessage("doomsday.command.give");
		if (args.length >= tire) {
			for (SubCommand subCommand : subCommands) {
				if (args[tire].equalsIgnoreCase(subCommand.getName())) {
					subCommand.onExecute(sender, args);
					break;
				}
			}
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == tire + 1) {
			return getSubCommandNames();
		} else if (args.length == tire) {
			List<String> list = new ArrayList<>();
			for (Player player : Bukkit.getOnlinePlayers()) {
				list.add(player.getName());
			}
			return list;
		} else {
			for (SubCommand subCommand : subCommands) {
				if (args[tire].equals(subCommand.getName())) {
					return subCommand.onTabComplete(sender, command, alias, args);
				}
			}
		}
		return null;
	}

	@Override
	public Permission getPermission() {
		return new Permission("doomsday.command.give");
	}

	@Override
	public String getDescription() {
		return "Give one player DoomsdayItems.";
	}
}
