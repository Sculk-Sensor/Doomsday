package me.sculk_sensor.doomsday.core.commands.subcommand.give;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.command.MainCommand;
import me.sculk_sensor.doomsday.api.command.SubCommand;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class GiveItem extends SubCommand {
	public GiveItem(Doomsday plugin, MainCommand mainCommand, String name, boolean hidden, SubCommand... subCommands) {
		super(plugin, mainCommand, name, hidden, 4, subCommands);
	}



	@Override
	public void onExecute(CommandSender sender, String[] args) {
		sender.sendMessage("doomsday.command.give.item");
		Player player = Bukkit.getPlayer(args[1]);
		if (player != null) {
			Location location = player.getLocation();
			DoomsdayItem doomsdayItem = Doomsday.getRegistry().getDoomsdayItem(args[3]);
			if (doomsdayItem != null) {
				if (args.length >= 5 && !StringUtils.isNumeric(args[4])) {
					sender.sendMessage("不是数");
					return;
				}
				Item entityItem = location.getWorld().spawn(location, Item.class);
				ItemStack givenItem = doomsdayItem.getItem().clone();
				entityItem.setItemStack(givenItem);
				if (args.length >= 5) {
					givenItem.setAmount(Integer.parseInt(args[4]));
				} else {
					givenItem.setAmount(1);
				}
				entityItem.setItemStack(givenItem);
				entityItem.setOwner(((Player) sender).getUniqueId());
				entityItem.setPickupDelay(0);
			} else {
				sender.sendMessage("错误ID");
			}
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		super.onTabComplete(sender, command, alias, args);
		List<String> complete = new ArrayList<>();
		if (args.length == 4) {
			for (DoomsdayItem doomsdayItem : Doomsday.getRegistry().getAllDoomsdayItems()) {
				complete.add(doomsdayItem.getId());
			}
		} else if (args.length == 5) {
			complete.add("1");
			complete.add("4");
			complete.add("16");
			complete.add("64");
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
