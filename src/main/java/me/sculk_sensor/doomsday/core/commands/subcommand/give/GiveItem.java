package me.sculk_sensor.doomsday.core.commands.subcommand.give;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.MainCommand;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.List;

public class GiveItem extends SubCommand {
	public GiveItem(Doomsday plugin, MainCommand mainCommand, String name, boolean hidden, SubCommand... subCommands) {
		super(plugin, mainCommand, name, hidden, subCommands);
	}

	@Override
	public void onExecute(CommandSender sender, String[] args) {
		sender.sendMessage("doomsday.command.give.item");
		if (args.length >= tire) {
			sender.sendMessage("give " + args[tire - 1]);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		super.onTabComplete(sender, command, alias, args);
		List<String> complete = new ArrayList<>();
		for (DoomsdayItem doomsdayItem : Doomsday.getRegistry().getAllDoomsdayItems()) {
			complete.add(doomsdayItem.getId());
		}
		return complete;
	}

	@Override
	public Permission getPermission() {
		return new Permission("doomsday.command.give.item");
	}

	@Override
	public String getDescription() {
		return "Give one player common DoomsdayItems.";
	}
}
