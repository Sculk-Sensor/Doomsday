package me.sculk_sensor.doomsday.api.item.handlers;

import me.sculk_sensor.doomsday.api.item.ItemHandler;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nonnull;

public interface InteractEntityHandler extends ItemHandler {
	void onPlayerInteractEntity(PlayerInteractEvent event);

	@Nonnull
	@Override
	default Class<? extends ItemHandler> getIdentifier() {return InteractEntityHandler.class;}

}
