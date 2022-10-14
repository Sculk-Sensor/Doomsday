package me.sculk_sensor.doomsday.core.registry;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.exception.DoomsdayItemDuplicateRegistrationException;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import me.sculk_sensor.doomsday.api.item.DoomsdayItemStack;
import me.sculk_sensor.doomsday.api.item.RadioactiveDoomsdayItem;
import me.sculk_sensor.doomsday.core.attribute.Radioactive;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.*;

public class DoomsdayRegistry {
	private final Map<String, DoomsdayItem> ids = new HashMap<>();
	private final List<DoomsdayItem> doomsdayItems = new ArrayList<>();
	private final List<DoomsdayItem> enabledItems = new ArrayList<>();
	private final List<DoomsdayItem> disabledItems = new ArrayList<>();
	private final List<DoomsdayItem> radioactiveItemsList = new ArrayList<>();
	private final Map<DoomsdayItem, Double> radioactiveIntensity = new HashMap<>();
	void registerItem(DoomsdayItem doomsdayItem) throws DoomsdayItemDuplicateRegistrationException {
		if (ids.containsKey(doomsdayItem.getId())) {
			throw new DoomsdayItemDuplicateRegistrationException("DoomsdayItem with the same ID cannot be registered twice!");
		}
		if (doomsdayItem instanceof Radioactive) {
			radioactiveItemsList.add(doomsdayItem);
			radioactiveIntensity.put(doomsdayItem, ((Radioactive) doomsdayItem).getRadioactiveIntensity());
		}
		doomsdayItems.add(doomsdayItem);
		ids.put(doomsdayItem.getId(), doomsdayItem);
	}
	List<DoomsdayItem> getAllDoomsdayItems() {
		return doomsdayItems;
	}
	List<DoomsdayItem> getEnabledDoomsdayItems() {
		return enabledItems;
	}
	List<DoomsdayItem> getDisabledDoomsdayItems() {
		return disabledItems;
	}
	List<DoomsdayItem> getRadioactiveItems() {
		return radioactiveItemsList;
	}
	Double getRadiationIntensity(@Nonnull DoomsdayItem doomsdayItem) {
		return radioactiveIntensity.getOrDefault(doomsdayItem, 0.0D);
	}
	Double getRadiationIntensity(@Nonnull ItemStack itemStack) {
		return radioactiveIntensity.getOrDefault(getDoomsdayItem(itemStack), 0.0D);
	}
	Double getRadiationIntensity(@Nonnull String id) {
		return radioactiveIntensity.getOrDefault(getDoomsdayItem(id), 0.0D);
	}
	DoomsdayItem getDoomsdayItem(ItemStack itemStack) {
		if (itemStack == null) {
			return null;
		}
		return getDoomsdayItem(Doomsday.getCustomItemIdService().getItemData(itemStack).orElse(null));
	}
	DoomsdayItem getDoomsdayItem(String id) {
		return ids.getOrDefault(id, null);
	}
}
