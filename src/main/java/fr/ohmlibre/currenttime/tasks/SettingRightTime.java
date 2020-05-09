package fr.ohmlibre.currenttime.tasks;

import fr.ohmlibre.currenttime.CurrentTime;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class SettingRightTime implements Runnable {
	private final CurrentTime instance;

	public SettingRightTime() {
		this.instance = JavaPlugin.getPlugin(CurrentTime.class);
	}

	@Override
	public void run() {
		long currentTime = LocalDateTime.now().toLocalTime().toSecondOfDay();
		currentTime /= 7.2;
		long finalCurrentTime = currentTime;

		List<String> worlds = this.instance.getConfig().getStringList("Worlds");

		worlds.forEach(worldName -> Objects.requireNonNull(Bukkit.getWorld(worldName),
				" The world " + worldName + " doesn't exist, please verify the configuration.").setFullTime(finalCurrentTime));
		
	}
}
