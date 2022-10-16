package me.sculk_sensor.doomsday.api.item.handlers;

import me.sculk_sensor.doomsday.api.item.ItemHandler;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nonnull;

public interface ItemUseHandler extends ItemHandler {
	void onPlayerRightClick(PlayerInteractEvent event);

	@Nonnull
	@Override
	default Class<? extends ItemHandler> getIdentifier() {
		return ItemUseHandler.class;
	}
}
