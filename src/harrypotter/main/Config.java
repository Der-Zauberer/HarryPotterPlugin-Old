package harrypotter.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Config {
	
	private static File file = new File("plugins/HarryPotterPlugin", "config.yml");
	public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);
	
	public enum Spell{AGUAMENTI, EXPELLIARMUS, INCENDIO, LUMOS, NOX, STUPOR};
	
	public Config() {
		if(!file.exists()) {
			saveConfig();
		}
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

}
