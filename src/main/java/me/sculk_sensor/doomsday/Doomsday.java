package me.sculk_sensor.doomsday;

import me.sculk_sensor.doomsday.api.item.CustomItemStack;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import me.sculk_sensor.doomsday.api.item.DoomsdayItemStack;
import me.sculk_sensor.doomsday.api.service.ItemDataService;
import me.sculk_sensor.doomsday.api.command.Completer;
import me.sculk_sensor.doomsday.core.commands.DoomsdayCommand;
import me.sculk_sensor.doomsday.core.commands.subcommand.SubCommands;
import me.sculk_sensor.doomsday.core.registry.DoomsdayRegistry;
import me.sculk_sensor.doomsday.listeners.PlayerLocaleChangeListener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import java.security.DomainLoadStoreParameter;
import java.util.ArrayList;
import java.util.logging.Level;

public final class Doomsday extends JavaPlugin {

	private static Doomsday instance;
	private ItemDataService itemIdService;
	private ItemDataService guidebookModeService;
	private DoomsdayRegistry registry;

	@Override
	public void onEnable() {
		instance = this;
		itemIdService = new ItemDataService(this, "doomsday-item-id");
		guidebookModeService = new ItemDataService(this, "doomsday-guidebook-mode");
		registry = new DoomsdayRegistry();
		DoomsdayCommand command = new DoomsdayCommand(this, new ArrayList<>());
		command.getSubCommands().addAll(SubCommands.getAllCommand(command));
		command.register();
		new PlayerLocaleChangeListener(this);
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("FIRST", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("SECOND", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("THIRD", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("FORTH", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("FIFTH", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("SIXTH", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		// Plugin startup logic
	}
	@Override
	public void onDisable() {
		instance = null;
		itemIdService = null;
		guidebookModeService = null;
		registry = null;
		// Plugin shutdown logic
	}

	public static @Nonnull Doomsday instance() {
		validateInstance();
		return instance;
	}
	private static void validateInstance() {
		if (instance == null) {
			throw new IllegalStateException("Cannot invoke static method, Doomsday instance is null.");
		}
	}
	public static @Nonnull ItemDataService getItemIdService() {
		validateInstance();
		return instance.itemIdService;
	}
	public static @Nonnull ItemDataService getGuidebookModeService() {
		validateInstance();
		return instance.guidebookModeService;
	}
	public static @Nonnull DoomsdayRegistry getRegistry() {
		validateInstance();
		return instance.registry;
	}
}
