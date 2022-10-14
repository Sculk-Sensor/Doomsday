package me.sculk_sensor.doomsday.api.recipes;

import me.sculk_sensor.doomsday.Doomsday;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class CustomRecipe implements Keyed {
	private final NamespacedKey key;
	private final RecipeType recipeType;
	private final ItemStack[] recipe;
	private final int recipeSize;
	public CustomRecipe(RecipeType recipeType, ItemStack... recipe) {
		this.key = new NamespacedKey(Doomsday.instance(), recipeType.toString() + Arrays.toString(recipe));
		this.recipeType = recipeType;
		this.recipeSize = recipe.length;
		this.recipe = recipe;
	}

	public RecipeType getRecipeType() {
		return recipeType;
	}

	public ItemStack[] getRecipe() {
		return recipe;
	}

	public int getRecipeSize() {
		return recipeSize;
	}

	@Nonnull
	@Override
	public NamespacedKey getKey() {
		return key;
	}
}
