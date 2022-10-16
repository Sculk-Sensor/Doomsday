package me.sculk_sensor.doomsday.core.commands;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.MainCommand;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.List;

public class DoomsdayCommand extends MainCommand {
	public DoomsdayCommand(Doomsday plugin, List<SubCommand> subCommands) {
		super(plugin, "doomsday", ChatColor.of(new Color(30, 30, 60)) + "[Doomsday] ", subCommands);
	}

	@Override
	public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
		if (args.length > 0) {
			for (SubCommand subCommand : subCommands) {
				if (args[0].equalsIgnoreCase(subCommand.getName())) {
					subCommand.onExecute(sender, args);
					break;
				}
			}
		}
		return !subCommands.isEmpty();
	}
	@Override
	public Permission getPermission() {
		return new Permission("doomsday.command");
	}
	@Override
	public String getDescription() {
		return "Open the main menu of the plugin.";
	}
}
