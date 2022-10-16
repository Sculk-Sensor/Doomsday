package me.sculk_sensor.doomsday.api.item;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.item.guidebook.Guidebook;
import me.sculk_sensor.doomsday.api.item.guidebook.GuidebookMode;
import me.sculk_sensor.doomsday.api.recipes.CustomRecipe;
import me.sculk_sensor.doomsday.api.recipes.RecipeType;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class DoomsdayItem {
	protected final String id;
	protected final DoomsdayItemStack itemStack;
	protected CustomRecipe[] recipes;
	public DoomsdayItem(DoomsdayItemStack itemStack) {
		Validate.notNull(itemStack, "You cannot instantiate DoomsdayItem with null ItemStack (parameter itemStack).");
		itemStack.lock();
		this.itemStack = itemStack;
		this.id = itemStack.getId();
	}
	protected DoomsdayItem(DoomsdayItemStack itemStack, boolean isGuidebook) {
		Validate.notNull(itemStack, "You cannot instantiate DoomsdayItem with null ItemStack (parameter itemStack).");
		Doomsday.getGuidebookModeService().setItemData(itemStack, GuidebookMode.SURVIVAL_MODE.getId());
		itemStack.lock();
		this.itemStack = itemStack;
		this.id = itemStack.getId();
	}
	public CustomRecipe[] getRecipes() {
		return recipes;
	}
	public DoomsdayItemStack getItem() {
		return itemStack;
	}
	public String getId() {
		return id;
	}
}
