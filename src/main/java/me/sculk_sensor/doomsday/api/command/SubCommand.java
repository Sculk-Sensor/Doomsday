package me.sculk_sensor.doomsday.api.command;

import me.sculk_sensor.doomsday.Doomsday;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.stream.Collectors;

public abstract class SubCommand {
	protected final JavaPlugin plugin;
	protected final MainCommand mainCommand;
	protected final String name;
	protected final boolean hidden;
	protected final List<SubCommand> subCommands;
	protected int tire;

	public void setTire(MainCommand mainCommand, int tire) {
		if (mainCommand == this.mainCommand) {
			this.tire = tire;
		}
	}

	public SubCommand(Doomsday plugin, MainCommand mainCommand, String name, boolean hidden, SubCommand... subCommands) {
		this.plugin = plugin;
		this.mainCommand = mainCommand;
		this.name = name;
		this.hidden = hidden;
		this.subCommands = List.of(subCommands);
		this.tire = -1;
	}

	public SubCommand(Doomsday plugin, MainCommand mainCommand, String name, boolean hidden, int tire, SubCommand... subCommands) {
		this.plugin = plugin;
		this.mainCommand = mainCommand;
		this.name = name;
		this.hidden = hidden;
		this.subCommands = List.of(subCommands);
		this.tire = tire;
	}

	public String getName() {
		return name;
	}
	public boolean isHidden() {
		return hidden;
	}
	public JavaPlugin getPlugin() {
		return plugin;
	}
	public void onExecute(CommandSender sender, String[] args) {
		if (args.length >= tire) {
			for (SubCommand subCommand : subCommands) {
				if (args[tire - 1].equalsIgnoreCase(subCommand.getName())) {
					subCommand.onExecute(sender, args);
					break;
				}
			}
		}
	}
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == tire) {
			return getSubCommandNames();
		} else {
			for (SubCommand subCommand : subCommands) {
				if (args[tire - 1].equals(subCommand.getName())) {
					return subCommand.onTabComplete(sender, command, alias, args);
				}
			}
		}
		return null;
	}
	public List<String> getSubCommandNames() {
		return subCommands.stream().map(SubCommand::getName).collect(Collectors.toList());
	}
	public List<SubCommand> getSubCommands() {
		return subCommands;
	}
	public abstract Permission getPermission();
	public abstract String getDescription();
}
