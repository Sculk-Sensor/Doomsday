package me.sculk_sensor.doomsday.listeners;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.item.ItemHandler;
import me.sculk_sensor.doomsday.api.item.handlers.DamageBlockHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

import java.util.List;

public class ItemHandlersListener implements Listener {
	public ItemHandlersListener(Doomsday plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	void onDamageBlockHandlerTriggered(BlockDamageEvent event) {
		String id = Doomsday.getItemIdService().getItemData(event.getItemInHand());
		if (id == null) {
			return;
		}
		if (Doomsday.getRegistry().hasHandler(id, DamageBlockHandler.class)) {
			for (ItemHandler handler : Doomsday.getRegistry().getHandlers(id, DamageBlockHandler.class)) {
				if (handler instanceof DamageBlockHandler) {
					((DamageBlockHandler) handler).onPlayerDamageBlock(event);
				}
			}
		}
	}
}
