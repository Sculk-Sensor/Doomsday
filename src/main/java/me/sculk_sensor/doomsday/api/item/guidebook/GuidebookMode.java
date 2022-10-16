package me.sculk_sensor.doomsday.api.item.guidebook;

public enum GuidebookMode {
	SURVIVAL_MODE("survival"),
	CHEAT_MODE("cheat");
	private final String id;
	private GuidebookMode(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
