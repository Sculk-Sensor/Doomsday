package me.sculk_sensor.doomsday.api.item;

import org.apache.commons.lang.Validate;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CustomItemStack extends ItemStack {
	public CustomItemStack(ItemStack item) {
		super(item);
	}
	public CustomItemStack(Material type) {
		super(type);
	}
	public CustomItemStack(ItemStack item, Consumer<ItemMeta> meta) {
		super(item);
		ItemMeta im = this.getItemMeta();
		meta.accept(im);
		this.setItemMeta(im);
	}
	public CustomItemStack(Material type, Consumer<ItemMeta> meta) {
		this(new ItemStack(type), meta);
	}
	public CustomItemStack(ItemStack item, String name, String... lore) {
		this(item, (itemMeta) -> {
			if (name != null) {
				itemMeta.setDisplayName(name);
			}
			if (lore.length > 0) {
				itemMeta.setLore(Arrays.asList(lore));
			}
		});
	}
	public CustomItemStack(ItemStack item, Color color, String name, String... lore) {
		this(item, (itemMeta) -> {
			if (name != null) {
				itemMeta.setDisplayName(name);
			}
			if (lore.length > 0) {
				itemMeta.setLore(Arrays.asList(lore));
			}

			if (itemMeta instanceof LeatherArmorMeta) {
				((LeatherArmorMeta)itemMeta).setColor(color);
			}

			if (itemMeta instanceof PotionMeta) {
				((PotionMeta)itemMeta).setColor(color);
			}

		});
	}
	public CustomItemStack addFlags(ItemFlag... flags) {
		ItemMeta itemMeta = this.getItemMeta();
		Validate.notNull(itemMeta, "ItemFlags cannot be add to null ItemMeta.");
		itemMeta.addItemFlags(flags);
		this.setItemMeta(itemMeta);
		return this;
	}
	public CustomItemStack setCustomModel(int data) {
		ItemMeta itemMeta = this.getItemMeta();
		Validate.notNull(itemMeta, "CustomModeData cannot be set to null ItemMeta.");
		itemMeta.setCustomModelData(data == 0 ? null : data);
		this.setItemMeta(itemMeta);
		return this;
	}
	public CustomItemStack(Material type, String name, String... lore) {
		this(new ItemStack(type), name, lore);
	}
	public CustomItemStack(Material type, String name, List<String> lore) {
		this(new ItemStack(type), name, lore.toArray(new String[0]));
	}
	public CustomItemStack(ItemStack item, List<String> list) {
		this(item, list.get(0), list.subList(1, list.size()).toArray(new String[0]));
	}
	public CustomItemStack(Material type, List<String> list) {
		this(new ItemStack(type), list);
	}
	public CustomItemStack(ItemStack item, int amount) {
		super(item);
		this.setAmount(amount);
	}
	public CustomItemStack(ItemStack item, Material type) {
		super(item);
		this.setType(type);
	}
}
