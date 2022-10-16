package me.sculk_sensor.doomsday.api.item;

import me.sculk_sensor.doomsday.Doomsday;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

public class DoomsdayItemStack extends ItemStack {
	private final String id;
	private boolean locked = false;
	private String texture = null;
	public DoomsdayItemStack(String id, ItemStack itemStack) {
		super(itemStack);
		ItemMeta itemMeta = getItemMeta();
		Validate.notNull(itemMeta, "ItemId cannot be add to null ItemMeta.");
		Doomsday.getItemIdService().setItemData(itemMeta, id);
		setItemMeta(itemMeta);
		this.id = id;
		locked = false;
	}

	public String getId() {
		return id;
	}
	public void lock() {
		locked = true;
	}
	private void unlock() {
		locked = false;
	}
	@Nonnull
	public DoomsdayItemStack clone() {
		DoomsdayItemStack replica = (DoomsdayItemStack) super.clone();
		replica.unlock();
		return replica;
	}
}
