package me.sculk_sensor.doomsday.api.item.handlers;

import me.sculk_sensor.doomsday.api.item.ItemHandler;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

import javax.annotation.Nonnull;

public interface DamageBlockHandler extends ItemHandler {
	void onBlockDamageEvent(BlockDamageEvent event);

	@Nonnull
	@Override
	default Class<? extends ItemHandler> getIdentifier() {
		return DamageBlockHandler.class;
	}
}
