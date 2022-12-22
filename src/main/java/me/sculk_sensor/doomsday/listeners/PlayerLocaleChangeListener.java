package me.sculk_sensor.doomsday.listeners;

import me.sculk_sensor.doomsday.Doomsday;
import me.sculk_sensor.doomsday.api.math.MathUtil;
import me.sculk_sensor.doomsday.utils.ParticleUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.*;

public class PlayerLocaleChangeListener implements Listener {
	public PlayerLocaleChangeListener(Doomsday plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	void onPlayerLocaleChange(PlayerLocaleChangeEvent e) {
		e.getPlayer().sendMessage(e.getLocale());
		e.getPlayer().getInventory().setItem(0, Doomsday.getRegistry().getDoomsdayItem("FIRST").getItem());
	}

	@EventHandler(priority = EventPriority.MONITOR)
	void onPlayerMove(PlayerMoveEvent e) {
		e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.BLACK + "" + net.md_5.bungee.api.ChatColor.BOLD + "Yaw: " + e.getPlayer().getLocation().getYaw() + ", Pitch: " + e.getPlayer().getLocation().getPitch()));
	}

	@EventHandler(priority = EventPriority.MONITOR)
	void onPlayerAttack(PlayerAnimationEvent e) {
		ParticleUtil.generateAttackTrajectories(e.getPlayer().getEyeLocation(), 45, 70, 1400, 2.5, 0, 0, 0, 0, Math.sqrt(8), 1);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	void onPlayerSendMessage(AsyncPlayerChatEvent e) {
		double a = Double.parseDouble(e.getMessage());
		if (a != 0) {
			e.getPlayer().sendMessage("sin:" + MathUtil.sin(a) + "°");
			e.getPlayer().sendMessage("cos:" + MathUtil.cos(a) + "°");
			e.getPlayer().sendMessage("tan:" + MathUtil.tan(a) + "°");
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	void onPlayerPickup(EntityPickupItemEvent e) {
		if (e.getEntity() instanceof Player) {
			//e.setCancelled(true);
		}
	}
}
