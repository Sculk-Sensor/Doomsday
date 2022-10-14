package me.sculk_sensor.doomsday;

import me.sculk_sensor.doomsday.api.service.CustomItemDataService;
import me.sculk_sensor.doomsday.listeners.PlayerLocaleChangeListener;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

public final class Doomsday extends JavaPlugin {

	private static Doomsday instance;
	private final CustomItemDataService customItemIdService = new CustomItemDataService(this, "doomsday-item");
	@Override
	public void onEnable() {
		instance = this;
		// Plugin startup logic
		new PlayerLocaleChangeListener(this);
	}

	@Override
	public void onDisable() {
		instance = null;
		// Plugin shutdown logic
	}

	public static @Nonnull Doomsday instance() {
		validateInstance();
		return instance;
	}

	private static void validateInstance() {
		if (instance == null) {
			throw new IllegalStateException("Cannot invoke static method, Doomsday instance is null.");
		}
	}

	public static @Nonnull CustomItemDataService getCustomItemIdService() {
		validateInstance();
		return instance.customItemIdService;
	}
}
