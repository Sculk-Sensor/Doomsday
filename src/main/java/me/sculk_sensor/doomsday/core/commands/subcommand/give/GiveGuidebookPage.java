package me.sculk_sensor.doomsday.core.commands.subcommand.give;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.MainCommand;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import java.util.List;

public class GiveGuidebookPage extends SubCommand {
	public GiveGuidebookPage(Doomsday plugin, MainCommand mainCommand, String name, boolean hidden, SubCommand... subCommands) {
		super(plugin, mainCommand, name, hidden, subCommands);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		sender.sendMessage("doomsday.command.give.guidebook-page");
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return null;
	}

	@Override
	public Permission getPermission() {
		return new Permission("doomsday.command.give.guidebook-page");
	}

	@Override
	public String getDescription() {
		return "Give one player a portion of a guidebook page.";
	}
}
