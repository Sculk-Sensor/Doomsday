package me.sculk_sensor.doomsday.core.commands.subcommand;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.MainCommand;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import org.bukkit.permissions.Permission;

public class Id extends SubCommand {
	public Id(Doomsday plugin, MainCommand mainCommand, String name, boolean hidden, SubCommand... subCommands) {
		super(plugin, mainCommand, name, hidden, subCommands);
	}

	@Override
	public Permission getPermission() {
		return new Permission("doomsday.command.id");
	}

	@Override
	public String getDescription() {
		return "Gets the id of the item in hand.";
	}
}
