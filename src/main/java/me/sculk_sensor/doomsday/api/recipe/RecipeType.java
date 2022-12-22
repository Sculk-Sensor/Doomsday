package me.sculk_sensor.doomsday.api.recipe;

import me.sculk_sensor.doomsday.Doomsday;
import org.apache.commons.lang.Validate;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class RecipeType implements Keyed {
	public static final RecipeType NULL = new RecipeType(new ItemStack(Material.AIR), "null");
	private final ItemStack icon;
	private final NamespacedKey key;

	public RecipeType(ItemStack icon, String id) {
		Validate.notNull(icon, "You cannot instantiate DoomsdayItem with null ItemStack (parameter icon).");
		Validate.notNull(icon, "You cannot instantiate DoomsdayItem with null String (parameter id).");
		this.icon = icon;
		this.key = new NamespacedKey(Doomsday.instance(), "recipe-" + id);
	}

	public ItemStack getIcon() {
		return icon;
	}

	@Nonnull
	@Override
	public NamespacedKey getKey() {
		return key;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RecipeType that = (RecipeType) o;
		return Objects.equals(icon, that.icon) && Objects.equals(key, that.key);
	}

	@Override
	public int hashCode() {
		return Objects.hash(icon, key);
	}

	@Override
	public String toString() {
		return "RecipeType{" +
				"icon=" + icon +
				", key=" + key +
				'}';
	}
}
