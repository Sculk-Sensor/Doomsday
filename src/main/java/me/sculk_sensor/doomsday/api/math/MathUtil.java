package me.sculk_sensor.doomsday.api.math;

public class MathUtil {
	private static final double radianConversion = Math.PI / 180;
	private static final double angleConversation = 180 / Math.PI;
	public static double sin(double angle) {
		return Math.sin(radianConversion * angle);
	}
	public static double cos(double angle) {
		return Math.cos(radianConversion * angle);
	}
	public static double tan(double angle) {
		return Math.tan(radianConversion * angle);
	}
	public static double csc(double angle) {
		return 1 / sin(angle);
	}
	public static double sec(double angle) {
		return 1 / cos(angle);
	}
	public static double cot(double angle) {
		return 1 / tan(angle);
	}
	public static double asin(double scale) {
		return Math.asin(scale) * angleConversation;
	}
	public static double acos(double scale) {
		return Math.acos(scale) * angleConversation;
	}
	public static double atan(double scale) {
		return Math.atan(scale) * angleConversation;
	}
	public static double acsc(double scale) {
		return asin(1 / scale);
	}
	public static double asec(double scale) {
		return acos(1 / scale);
	}
	public static double acot(double scale) {
		return atan(1 / scale);
	}
}
