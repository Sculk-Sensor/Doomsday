package me.sculk_sensor.doomsday.core.commands.subcommand;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import me.sculk_sensor.doomsday.core.commands.DoomsdayCommand;
import me.sculk_sensor.doomsday.core.commands.subcommand.give.GiveGuidebookPage;
import me.sculk_sensor.doomsday.core.commands.subcommand.give.GiveItem;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class SubCommands {
	public static List<SubCommand> getAllCommand(@Nonnull DoomsdayCommand mainCommand) {
		Doomsday plugin = (Doomsday) mainCommand.getPlugin();
		List<SubCommand> subCommands = new ArrayList<>();
		subCommands.add(new Give(plugin, mainCommand, "give", true,
				new GiveItem(plugin, mainCommand, "item", true),
				new GiveGuidebookPage(plugin, mainCommand, "guidebookpage", true)));
		subCommands.add(new Id(plugin, mainCommand, "id", true));
		subCommands.add(new Guide(plugin, mainCommand, "guide", true));
		return subCommands;
	}
}
