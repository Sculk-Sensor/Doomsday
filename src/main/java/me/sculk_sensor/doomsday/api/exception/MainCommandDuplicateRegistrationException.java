package me.sculk_sensor.doomsday.api.exception;

public class MainCommandDuplicateRegistrationException extends Exception {
	public MainCommandDuplicateRegistrationException(String reason) {
		super(reason);
	}
}
