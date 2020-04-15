package harrypotter.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import harrypotter.commands.ItemCommand;
import harrypotter.handler.ItemHandler;
import harrypotter.items.ItemWand;

public class HarryPotterPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		ItemHandler.registerItem(ItemWand.getItem());
		ItemHandler.registerItemFunction(new ItemWand());
		getCommand("harrypotter").setExecutor(new ItemCommand());
		Bukkit.getPluginManager().registerEvents(new ItemHandler(), this);
	}

}
