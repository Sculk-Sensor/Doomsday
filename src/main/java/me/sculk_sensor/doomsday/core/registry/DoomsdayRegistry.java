package me.sculk_sensor.doomsday.core.registry;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.exception.DoomsdayItemDuplicateRegistrationException;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import me.sculk_sensor.doomsday.api.attributes.Radioactive;
import me.sculk_sensor.doomsday.api.item.itemgroup.ItemGroup;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.logging.Level;

public class DoomsdayRegistry {
	private final Map<String, DoomsdayItem> ids = new HashMap<>();
	private final List<DoomsdayItem> doomsdayItems = new ArrayList<>();
	private final List<DoomsdayItem> enabledItems = new ArrayList<>();
	private final List<DoomsdayItem> disabledItems = new ArrayList<>();
	private final List<DoomsdayItem> radioactiveItemsList = new ArrayList<>();
	private final Map<DoomsdayItem, Double> radioactiveIntensity = new HashMap<>();
	private final List<ItemGroup> itemGroups = new ArrayList<>();

	public void registerItem(DoomsdayItem doomsdayItem) {
		if (ids.containsKey(doomsdayItem.getId())) {
			Doomsday.instance().getLogger().log(Level.SEVERE, "DoomsdayItem with the same ID cannot be registered twice!");
			return;
		}
		if (doomsdayItem instanceof Radioactive) {
			radioactiveItemsList.add(doomsdayItem);
			radioactiveIntensity.put(doomsdayItem, ((Radioactive) doomsdayItem).getRadioactiveIntensity());
		}
		doomsdayItems.add(doomsdayItem);
		ids.put(doomsdayItem.getId(), doomsdayItem);
	}
	public void registerGroup(ItemGroup itemGroup) {

	}
	public List<DoomsdayItem> getAllDoomsdayItems() {
		return doomsdayItems;
	}
	public List<DoomsdayItem> getEnabledDoomsdayItems() {
		return enabledItems;
	}
	public List<DoomsdayItem> getDisabledDoomsdayItems() {
		return disabledItems;
	}
	public List<DoomsdayItem> getRadioactiveItems() {
		return radioactiveItemsList;
	}
	public Double getRadiationIntensity(@Nonnull DoomsdayItem doomsdayItem) {
		return radioactiveIntensity.getOrDefault(doomsdayItem, 0.0D);
	}
	public Double getRadiationIntensity(@Nonnull ItemStack itemStack) {
		return radioactiveIntensity.getOrDefault(getDoomsdayItem(itemStack), 0.0D);
	}
	public Double getRadiationIntensity(@Nonnull String id) {
		return radioactiveIntensity.getOrDefault(getDoomsdayItem(id), 0.0D);
	}
	public DoomsdayItem getDoomsdayItem(ItemStack itemStack) {
		if (itemStack == null) {
			return null;
		}
		return getDoomsdayItem(Doomsday.getItemIdService().getItemData(itemStack).orElse(null));
	}
	public DoomsdayItem getDoomsdayItem(String id) {
		return ids.getOrDefault(id, null);
	}
}
