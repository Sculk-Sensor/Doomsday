package me.sculk_sensor.doomsday.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import javax.annotation.Nonnull;
import java.util.List;

public class Completer implements TabCompleter {
	private final MainCommand mainCommand;

	public Completer(MainCommand mainCommand) {
		this.mainCommand = mainCommand;
	}

	@Override
	public List<String> onTabComplete(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
		if (args.length == 1) {
			return mainCommand.getSubCommandNames();
		} else {
			for (SubCommand subCommand : mainCommand.getSubCommands()) {
				if (args[0].equals(subCommand.getName())) {
					return subCommand.onTabComplete(sender, command, label, args);
				}
			}
		}
		return null;
	}
}