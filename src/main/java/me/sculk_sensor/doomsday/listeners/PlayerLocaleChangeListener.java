package me.sculk_sensor.doomsday.listeners;

import me.sculk_sensor.doomsday.Doomsday;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLocaleChangeEvent;

public class PlayerLocaleChangeListener implements Listener {
	public PlayerLocaleChangeListener(Doomsday plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	void onPlayerLocaleChange(PlayerLocaleChangeEvent e) {
		e.getPlayer().sendMessage(e.getLocale());
	}
}
