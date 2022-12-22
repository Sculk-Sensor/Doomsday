package me.sculk_sensor.doomsday.api.item;

import javax.annotation.Nonnull;
import java.util.Optional;

public interface ItemHandler {
	@Nonnull
	Class<? extends ItemHandler> getIdentifier();

}
