package harrypotter.main;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private static File file = new File("plugins/System", "config.yml");
	public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);
	
	public enum Spell{AGUAMENTI, EXPELLIARMUS, INCENDIO, LUMOS, NOX, STUPOR};
	
	public Config() {
		if(!file.exists()) {
			saveConfig();
		}
	}
	
	public static void addSpellToPlayer(Spell spell) {
		
	}
	
	public static Spell hasPlayerSpell() {
		return null;
	}
	
	public static void saveConfig() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
