package me.sculk_sensor.doomsday.api.command;

import me.sculk_sensor.doomsday.Doomsday;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.stream.Collectors;

public abstract class MainCommand implements CommandExecutor{
	protected boolean registered = false;
	protected final JavaPlugin plugin;
	protected final List<SubCommand> subCommands;
	protected final String name;
	protected final String messagePrefix;

	public MainCommand(Doomsday plugin, String name, String messagePrefix, List<SubCommand> subCommands) {
		this.plugin = plugin;
		this.name = name;
		this.messagePrefix = messagePrefix;
		this.subCommands = subCommands;
	}

	public void register() {
		if (registered) {
			return;
		}
		try {
			setSubCommandTire();
			Objects.requireNonNull(plugin.getCommand(name)).setExecutor(this);
			Objects.requireNonNull(plugin.getCommand(name)).setTabCompleter(new Completer(this));
			registered = true;
		} catch (Exception e) {
			plugin.getLogger().log(Level.SEVERE, "MainCommand registration failed!");
		}
	}
	protected final void dfsSetTire(int tire, SubCommand subCommands) {
		if (tire == 1) {
			tire = 2;
		}
		if (subCommands.tire == -1) {
			subCommands.setTire(this, tire);
		} else {
			tire = subCommands.tire;
		}
		for (SubCommand subCommand : subCommands.subCommands) {
			dfsSetTire(tire + 1, subCommand);
		}
	}
	protected final void setSubCommandTire() {
		for (SubCommand subCommand : subCommands) {
			dfsSetTire(2, subCommand);
		}
	}
	public abstract Permission getPermission();
	public abstract String getDescription();
	public JavaPlugin getPlugin() {
		return plugin;
	}
	public List<String> getSubCommandNames() {
		return subCommands.stream().map(SubCommand::getName).collect(Collectors.toList());
	}
	public List<SubCommand> getSubCommands() {
		return subCommands;
	}
	public void sendHelp (@Nonnull CommandSender sender) {

	}
	@Override
	public abstract boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command,
									  @Nonnull String label, @Nonnull String[] args);
}
