package me.sculk_sensor.doomsday.api.localization;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocalizeManager {
	public String localize(Player player, String message) {
		return message;
	}
	public String localize(CommandSender sender, String message) {
		if (sender instanceof Player) {
			return message;
		}
		return message;
	}
}
