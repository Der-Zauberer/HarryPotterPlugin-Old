package harrypotter.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import harrypotter.commands.ItemCommand;
import harrypotter.handler.ItemHandler;
import harrypotter.items.WandItem;

public class HarryPotterPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("harrypotter").setExecutor(new ItemCommand());
		Bukkit.getPluginManager().registerEvents(new ItemHandler(), this);
		registerItems();
	}
	
	private void registerItems() {
		ItemHandler.registerItem(new WandItem());
	}

}
