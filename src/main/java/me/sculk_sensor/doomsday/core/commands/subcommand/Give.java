package me.sculk_sensor.doomsday.core.commands.subcommand;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.MainCommand;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import me.sculk_sensor.doomsday.core.commands.DoomsdayCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import java.util.List;

public class Give extends SubCommand {
	public Give(Doomsday plugin, DoomsdayCommand mainCommand, String name, boolean hidden, SubCommand... subCommands) {
		super(plugin, mainCommand, name, hidden, subCommands);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		sender.sendMessage("doomsday.command.give");
		super.onExecute(sender, args);
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
