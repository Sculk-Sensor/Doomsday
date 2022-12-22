package me.sculk_sensor.doomsday.api.item.itemgroup;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import org.apache.commons.lang.Validate;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ItemGroup implements Keyed {
	private final JavaPlugin plugin;
	protected final List<DoomsdayItem> itemList = new ArrayList<>();
	protected final List<ItemGroup> subGroups;
	protected ItemGroup fatherGroup;
	protected final String id;
	protected final NamespacedKey key;
	protected final ItemStack icon;
	protected final int priority;

	public ItemGroup(JavaPlugin plugin, String id, String key, ItemStack icon, int priority, ItemGroup... subGroups) {
		Validate.notNull(key, "An ItemGroup's key must not be null!");
		Validate.notNull(id, "An ItemGroup's id must not be null!");
		Validate.notNull(icon, "An ItemGroup's icon must not be null!");
		this.plugin = plugin;
		this.id = id;
		this.key = new NamespacedKey(plugin, key);
		this.icon = icon;
		this.priority = priority;
		this.subGroups = List.of(subGroups);
		for (ItemGroup subGroup : subGroups) {
			subGroup.setFatherGroup(this);
		}
	}

	protected void setFatherGroup(ItemGroup fatherGroup) {
		this.fatherGroup = fatherGroup;
	}
	public void addItem(DoomsdayItem doomsdayItem) {
		this.itemList.add(doomsdayItem);
	}
	public JavaPlugin getPlugin() {
		return plugin;
	}
	public String getId() {
		return id;
	}
	public ItemStack getIcon() {
		return icon;
	}
	public int getPriority() {
		return priority;
	}
	public List<ItemGroup> getSubGroups() {
		return subGroups;
	}
	public ItemGroup getFatherGroup() {
		return fatherGroup;
	}

	@Nonnull
	@Override
	public NamespacedKey getKey() {
		return key;
	}
}
