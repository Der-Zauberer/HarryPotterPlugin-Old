package harrypotter.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
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
		registerCraftingRecipies();
	}
	
	private void registerItems() {
		ItemHandler.registerItem(new WandItem());
	}
	
	@SuppressWarnings("deprecation")
	private void registerCraftingRecipies() {
		ShapedRecipe shapedrecipe = new ShapedRecipe(new WandItem().getItem()).shape("xxd","xsx","sxx").setIngredient('x', Material.AIR).setIngredient('s', Material.STICK).setIngredient('d', Material.DIAMOND);
		getServer().addRecipe(shapedrecipe);
	}

}
