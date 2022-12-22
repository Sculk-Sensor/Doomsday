package me.sculk_sensor.doomsday.api.recipe;

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
	private final RecipeOutput recipeOutput;
	private final int recipeSize;
	public CustomRecipe(RecipeType recipeType, RecipeOutput recipeOutput, ItemStack... recipe) {
		this.key = new NamespacedKey(Doomsday.instance(), recipeType.toString() + Arrays.toString(recipe));
		this.recipeType = recipeType;
		this.recipeOutput = recipeOutput;
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
	public RecipeOutput getRecipeOutput() {
		return recipeOutput;
	}

	@Nonnull
	@Override
	public NamespacedKey getKey() {
		return key;
	}
}
