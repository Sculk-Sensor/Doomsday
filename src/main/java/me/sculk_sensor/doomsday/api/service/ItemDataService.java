package me.sculk_sensor.doomsday.api.service;

import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class ItemDataService implements Keyed {
	private final NamespacedKey namespacedKey;
	public ItemDataService(Plugin plugin, String key) {
		namespacedKey = new NamespacedKey(plugin, key);
	}

	public void setItemData(@Nonnull ItemStack item, @Nonnull String data) {
		Validate.notNull(item, "The item cannot be null!");
		Validate.notNull(data, "Cannot store null on an item!");
		ItemMeta itemMeta = item.getItemMeta();
		Validate.notNull(itemMeta, "The ItemMeta of the item is null");
		setItemData(itemMeta, data);
		item.setItemMeta(itemMeta);
	}

	public void setItemData(@Nonnull ItemMeta meta, @Nonnull String data) {
		org.apache.commons.lang.Validate.notNull(meta, "The ItemMeta cannot be null!");
		Validate.notNull(data, "Cannot store null on an ItemMeta!");
		PersistentDataContainer container = meta.getPersistentDataContainer();
		container.set(namespacedKey, PersistentDataType.STRING, data);
	}

	public @Nonnull Optional<String> getItemData(@Nullable ItemStack item) {
		if (item == null || item.getType() == Material.AIR || !item.hasItemMeta()) {
			return Optional.empty();
		}
		ItemMeta itemMeta = item.getItemMeta();
		Validate.notNull(itemMeta, "The ItemMeta of the item is null");
		return getItemData(itemMeta);
	}

	public @Nonnull Optional<String> getItemData(@Nonnull ItemMeta meta) {
		Validate.notNull(meta, "Cannot read data from null!");
		PersistentDataContainer container = meta.getPersistentDataContainer();
		return Optional.ofNullable(container.get(namespacedKey, PersistentDataType.STRING));
	}

	@Nonnull
	@Override
	public NamespacedKey getKey() {
		return namespacedKey;
	}
}
