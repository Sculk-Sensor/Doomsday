package me.sculk_sensor.doomsday.api.item.guidebook;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import me.sculk_sensor.doomsday.api.item.DoomsdayItemStack;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

public class Guidebook extends DoomsdayItem implements Keyed {
	private final NamespacedKey key;
	public Guidebook(DoomsdayItemStack itemStack, JavaPlugin plugin, String key) {
		super(itemStack);
		Doomsday.getGuidebookModeService().setItemData(itemStack, GuidebookMode.SURVIVAL_MODE.getId());
		this.key = new NamespacedKey(plugin, key);
	}

	@Nonnull
	@Override
	public NamespacedKey getKey() {
		return key;
	}
}
