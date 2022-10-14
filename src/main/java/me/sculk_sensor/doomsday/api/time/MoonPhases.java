package me.sculk_sensor.doomsday.api.time;

import org.bukkit.World;

public enum MoonPhases {
	FULL_MOON(0, "full-moon"),
	GIBBOUS_MOON(1, "gibbous-moon"),
	HALF_MOON(2, "half-moon"),
	WANING_MOON(3, "waning-moon"),
	NEW_MOON(4, "new moon"),
	CRESCENT_MOON(5, "crescent-moon"),
	FIRST_QUARTER_MOON(6, "first-quarter-moon"),
	WAXING_GIBBOUS_MOON(7, "waxing-gibbous-moon");
	private final int index;
	private final String name;
	private MoonPhases(int index, String name) {
		this.index = index;
		this.name = name;
	}
	public void setMoonPhases(World world, MoonPhases moonPhases) {
		long dayTime = world.getTime() % 24000;
		world.setTime(dayTime + (long) moonPhases.index * 24000);
	}
	MoonPhases getCurMoonPhases(World world) {
		long days = world.getTime() / 24000;
		return MoonPhases.values()[(int) days % MoonPhases.values().length];
	}
	public String getName(MoonPhases moonPhases) {
		return moonPhases.name;
	}
}
