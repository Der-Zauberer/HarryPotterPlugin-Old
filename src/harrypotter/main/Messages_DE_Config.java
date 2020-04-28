package harrypotter.main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages_DE_Config {

    public static File file = new File("plugins/HarryPotterPlugin", "messages_de.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public Messages_DE_Config() {
        if(!file.exists()) {
            config.set("alerts", true);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File getFile() { return file; }

    public static FileConfiguration getConfig() { return config; }

    public static void saveDefaultConfig() {
        config.addDefault("prefix", "&b[HarryPotter]");

        // for error and successful
        config.addDefault("error", "%prefix% §c");
        config.addDefault("successful", "%prefix% §b");


        // for Commands
        config.addDefault("command", "%prefix% §b");

        // for other messages
        config.addDefault("othermessage", "%prefix §b");

        config.options().copyDefaults(true);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
