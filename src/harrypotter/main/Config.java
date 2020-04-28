package harrypotter.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import harrypotter.handler.SpellHandler.Spell;

public class Config {
	
	private static File file = new File("plugins/HarryPotterPlugin", "config.yml");
	public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);
	
	public Config() {
		if(!file.exists()) {
			config.set("language", "de");
			config.set("alerts", true);
			saveConfig();
		}
	}
	
	public static void setAlertEnabled(boolean enabled) {
		config.set("alerts", enabled);
	}
	
	public static boolean areAlertsEnabled() {
		return config.getBoolean("alerts");
	}
	
	public static void addSpellToPlayer(Player player, Spell spell) {
		List<String> spells = config.getStringList(player.getUniqueId() + ".spells");
		spells.add(spell.toString().toLowerCase());
		config.set(player.getUniqueId() + ".spells", spells);
		saveConfig();
	}
	
	public static boolean hasPlayerSpell(Player player, Spell spell) {
		List<String> spells = config.getStringList(player.getUniqueId() + ".spells");
		if(spells.contains(spell.toString().toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public static void saveConfig() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static File getLanguageFile() {
		File file = new File("plugins/HarryPotterPlugin", "messages_" + config.getString("language").toLowerCase() + ".yml");
		if (file.exists()) {
			return file;
		} else {
			return null;
		}
	}

	public static FileConfiguration getLanguage() {
		File file = new File("plugins/HarryPotterPlugin", "messages_" + config.getString("language").toLowerCase() + ".yml");
		if (file.exists()) {
			return YamlConfiguration.loadConfiguration(file);
		} else {
			return null;
		}
	}
}
