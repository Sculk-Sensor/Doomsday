package me.sculk_sensor.doomsday.api.item;

import me.sculk_sensor.doomsday.api.attributes.Radioactive;

public class RadioactiveDoomsdayItem extends DoomsdayItem implements Radioactive {

	private final double radioactiveIntensity;

	public RadioactiveDoomsdayItem(DoomsdayItemStack itemStack, double radioactiveIntensity) {
		super(itemStack);
		this.radioactiveIntensity = radioactiveIntensity;
	}

	@Override
	public double getRadioactiveIntensity() {
		return radioactiveIntensity;
	}
}
