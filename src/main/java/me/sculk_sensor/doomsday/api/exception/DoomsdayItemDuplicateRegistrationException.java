package me.sculk_sensor.doomsday.api.exception;

import com.sun.org.apache.xml.internal.dtm.ref.dom2dtm.DOM2DTMdefaultNamespaceDeclarationNode;

public class DoomsdayItemDuplicateRegistrationException extends Exception {
	public DoomsdayItemDuplicateRegistrationException(String reason) {
		super(reason);
	}
}
