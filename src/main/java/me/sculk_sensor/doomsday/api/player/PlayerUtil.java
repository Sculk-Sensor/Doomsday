package me.sculk_sensor.doomsday.api.player;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerUtil {
	void freeSpace(Player player, ItemStack itemStack) {
		int num = 0;
		for (ItemStack playerItem : player.getInventory()) {
			if (playerItem.isSimilar(itemStack)) {
				int addend = playerItem.getMaxStackSize() - playerItem.getAmount();
				num += Math.max(addend, 0);
			}
		}
	}
}
