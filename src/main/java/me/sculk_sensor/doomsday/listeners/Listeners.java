package me.sculk_sensor.doomsday.listeners;

import me.sculk_sensor.doomsday.Doomsday;

public class Listeners {
	private static boolean registered = false;
	public static void setUp(Doomsday plugin) {
		if (!registered) {
			new ItemHandlersListener(plugin);
			new PlayerLocaleChangeListener(plugin);
			registered = true;
		}
	}
}
