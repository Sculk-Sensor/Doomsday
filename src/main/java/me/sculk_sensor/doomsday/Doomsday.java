package me.sculk_sensor.doomsday;

import me.sculk_sensor.doomsday.api.item.CustomItemStack;
import me.sculk_sensor.doomsday.api.item.DoomsdayItem;
import me.sculk_sensor.doomsday.api.item.DoomsdayItemStack;
import me.sculk_sensor.doomsday.api.item.handlers.DamageBlockHandler;
import me.sculk_sensor.doomsday.api.service.ItemDataService;
import me.sculk_sensor.doomsday.core.commands.DoomsdayCommand;
import me.sculk_sensor.doomsday.core.commands.subcommand.SubCommands;
import me.sculk_sensor.doomsday.core.registry.DoomsdayRegistry;
import me.sculk_sensor.doomsday.listeners.Listeners;
import me.sculk_sensor.doomsday.listeners.PlayerLocaleChangeListener;
import me.sculk_sensor.doomsday.api.math.MathUtil;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Doomsday extends JavaPlugin {

	private static Doomsday instance;
	private ItemDataService itemIdService;
	private ItemDataService guidebookModeService;
	private DoomsdayRegistry registry;

	@Override
	public void onEnable() {
		instance = this;
		Logger logger = getLogger();
		logger.log(Level.INFO, ChatColor.DARK_RED + "!!!!!");
		itemIdService = new ItemDataService(this, "doomsday-item-id");
		guidebookModeService = new ItemDataService(this, "doomsday-guidebook-mode");
		registry = new DoomsdayRegistry();

		DoomsdayCommand command = new DoomsdayCommand(this, new ArrayList<>());
		command.getSubCommands().addAll(SubCommands.getAllCommand(command));
		command.register();

		Listeners.setUp(this);
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("FIRST", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("SECOND", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("THIRD", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("FORTH", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		registry.registerItem(new DoomsdayItem(new DoomsdayItemStack("FIFTH", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))));
		new DoomsdayItem(new DoomsdayItemStack("SIXTH", new CustomItemStack(Material.IRON_BLOCK, ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!", ChatColor.AQUA + "FIRST ITEM!"))).register().addHandler(new DamageBlockHandler() {
			@Override
			public void onPlayerDamageBlock(BlockDamageEvent event) {
				event.getBlock().setType(Material.GOLD_BLOCK);
			}
		});

		// Plugin startup logic
		AtomicInteger a = new AtomicInteger();
		Bukkit.getScheduler().runTaskTimer(this, () -> {
			for (int i = 0; i < 5; i++) {
				a.addAndGet(3);
				double x = 2 * MathUtil.cos(a.get());
				double z = 2 * MathUtil.sin(a.get());
				for (Player player : Bukkit.getOnlinePlayers()) {
					player.getLocation().getWorld().spawnParticle(Particle.REDSTONE, x, 100, z, 2, new Particle.DustOptions(Color.fromRGB(255, 127, 127), 0.4F));
				}
			}
		}, 1, 0);

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
