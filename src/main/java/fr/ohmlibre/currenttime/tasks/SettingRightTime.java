package fr.ohmlibre.currenttime.tasks;

import fr.ohmlibre.currenttime.CurrentTime;
import org.bukkit.Bukkit;

import java.time.LocalDateTime;
import java.util.List;

public class SettingRightTime implements Runnable {
	private final CurrentTime instance;

	public SettingRightTime(CurrentTime currentTime) {
		this.instance = currentTime;
	}

	@Override
	public void run() {
		long currentTime = LocalDateTime.now().toLocalTime().toSecondOfDay();

		currentTime /= 7.2;

		List<String> worlds = this.instance.getConfig().getStringList("Worlds");

		for (String world : worlds) {
			Bukkit.getWorld(world).setFullTime(currentTime);
		}
	}
}
