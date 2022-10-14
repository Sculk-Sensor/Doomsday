package me.sculk_sensor.doomsday.api.item;

import me.sculk_sensor.doomsday.core.attribute.Radioactive;

public class RadioactiveDoomsdayItem extends DoomsdayItem implements Radioactive {

	private final double radioactiveIntensity;

	public RadioactiveDoomsdayItem(String id, double radioactiveIntensity) {
		super(id);
		this.radioactiveIntensity = radioactiveIntensity;
	}

	@Override
	public double getRadioactiveIntensity() {
		return radioactiveIntensity;
	}
}
