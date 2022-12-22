package me.sculk_sensor.doomsday.api.mechanism;

public class MinecraftRelativeCoordinates {
	public double x, y, z;
	public MinecraftRelativeCoordinates(CoordinateSystemType systemType, Class<?> coordinateType) {
		if (coordinateType != systemType.coordinateType) {

		}
	}
}
