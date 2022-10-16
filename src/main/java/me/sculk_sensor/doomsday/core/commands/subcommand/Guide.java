package me.sculk_sensor.doomsday.core.commands.subcommand;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.MainCommand;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import org.bukkit.permissions.Permission;

public class Guide extends SubCommand {
	public Guide(Doomsday plugin, MainCommand mainCommand, String name, boolean hidden, SubCommand... subCommands) {
		super(plugin, mainCommand, name, hidden, subCommands);
	}

	@Override
	public Permission getPermission() {
		return new Permission("doomsday.command.guide");
	}

	@Override
	public String getDescription() {
		return "Get a empty guidebook.";
	}
}
