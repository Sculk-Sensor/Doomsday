package me.sculk_sensor.doomsday.core.registry;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import me.sculk_sensor.doomsday.api.attributes.Radioactive;
import me.sculk_sensor.doomsday.api.item.ItemHandler;
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
	private final Map<DoomsdayItem, Map<Class<? extends ItemHandler>, List<ItemHandler>>> handlerList = new HashMap<>();

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
		return getDoomsdayItem(Doomsday.getItemIdService().getItemData(itemStack));
	}

	public void addItemHandler(DoomsdayItem doomsdayItem, ItemHandler handler) {
		Map<Class<? extends ItemHandler>, List<ItemHandler>> target = new HashMap<>();
		if (!handlerList.containsKey(doomsdayItem)) {
			handlerList.put(doomsdayItem, new HashMap<>());
		} else {
			if (handlerList.get(doomsdayItem) == null) {
				handlerList.replace(doomsdayItem, new HashMap<>());
			}
		}
		target = handlerList.get(doomsdayItem);
		if (!target.containsKey(handler.getIdentifier())) {
			target.put(handler.getIdentifier(), new ArrayList<>());
		}
		target.get(handler.getIdentifier()).add(handler);
	}

	public boolean hasHandler(DoomsdayItem doomsdayItem) {
		return handlerList.containsKey(doomsdayItem);
	}

	public boolean hasHandler(DoomsdayItem doomsdayItem, Class<? extends ItemHandler> identifier) {
		if (hasHandler(doomsdayItem)) {
			return  handlerList.get(doomsdayItem).containsKey(identifier);
		}
		return false;
	}

	public boolean hasHandler(String id) {
		return handlerList.containsKey(getDoomsdayItem(id));
	}

	public boolean hasHandler(String id, Class<? extends ItemHandler> identifier) {
		if (hasHandler(getDoomsdayItem(id))) {
			return handlerList.get(getDoomsdayItem(id)).containsKey(identifier);
		}
		return false;
	}

	public Map<Class<? extends ItemHandler>, List<ItemHandler>> getHandlers(String id) {
		return handlerList.getOrDefault(getDoomsdayItem(id), null);
	}

	public List<ItemHandler> getHandlers(String id, Class<? extends ItemHandler> identifier) {
		Map<Class<? extends ItemHandler>, List<ItemHandler>> target = getHandlers(id);
		if (target == null) {
			return null;
		}
		return target.getOrDefault(identifier, null);
	}

	public DoomsdayItem getDoomsdayItem(String id) {
		return ids.getOrDefault(id, null);
	}
}
