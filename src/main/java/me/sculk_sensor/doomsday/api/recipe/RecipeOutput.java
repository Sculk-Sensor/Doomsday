package me.sculk_sensor.doomsday.api.recipe;

import me.sculk_sensor.doomsday.api.datastructure.Pair;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RecipeOutput {
	private List<Pair<ItemStack, Double>> outputs = new ArrayList<>();

	public RecipeOutput(List<Pair<ItemStack, Double>> outputs) {
		this.outputs = outputs;
	}
	public RecipeOutput(Pair<ItemStack, Double>[] outputs) {
		this.outputs.addAll(List.of(outputs));
	}

	public void addOutput(Pair<ItemStack, Double> output) {
		outputs.add(output);
	}
	public List<ItemStack> getRandomOutput() {
		List<ItemStack> outputList = new ArrayList<>();
		for (Pair<ItemStack, Double> output : outputs) {
			boolean rep = false;
			if (ThreadLocalRandom.current().nextDouble() <= output.value) {
				for (int i = 0; i < outputList.size(); i++) {
					if (outputList.get(i).isSimilar(output.key)) {
						ItemStack newItem = outputList.get(i);
						newItem.setAmount(outputList.get(i).getAmount() + output.key.getAmount());
						outputList.set(i, newItem);
						rep = true;
						break;
					}
				}
				if (!rep) {
					outputList.add(output.key);
				}
			}
		}
		return outputList;
	}
}
