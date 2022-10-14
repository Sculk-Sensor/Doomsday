package me.sculk_sensor.doomsday.api.item;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.recipes.CustomRecipe;
import me.sculk_sensor.doomsday.api.recipes.RecipeType;
import org.apache.commons.lang.Validate;

import java.util.*;

public class DoomsdayItem {
	private final String id;
	private final DoomsdayItemStack itemStack;
	private final CustomRecipe[] recipes;
	public DoomsdayItem(DoomsdayItemStack itemStack, CustomRecipe... recipes) {
		Validate.notNull(itemStack, "You cannot instantiate DoomsdayItem with null ItemStack (parameter itemStack).");
		this.itemStack = itemStack;
		this.id = itemStack.getId();
		this.recipes = recipes;
	}
	public CustomRecipe[] getRecipes() {
		return recipes;
	}
	public String getId() {
		return id;
	}
}
