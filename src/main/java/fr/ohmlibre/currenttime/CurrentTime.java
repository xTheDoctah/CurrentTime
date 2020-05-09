package fr.ohmlibre.currenttime;

import fr.ohmlibre.currenttime.tasks.SettingRightTime;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CurrentTime extends JavaPlugin {
	@Override
	public void onEnable() {
		this.saveDefaultConfig();

		if (this.getConfig().getBoolean("Enabled")) {
			Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new SettingRightTime(this), 200, 20);
		}
	}
}
