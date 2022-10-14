package me.sculk_sensor.doomsday.api.item;

import org.bukkit.inventory.ItemStack;

public class DoomsdayItemStack extends ItemStack {
	private String id;
	private boolean locked = false;
	private String texture = null;
	public DoomsdayItemStack(String id, ItemStack itemStack) {
		super(itemStack);
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
