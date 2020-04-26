package harrypotter.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import harrypotter.commands.ItemCommand;
import harrypotter.handler.ItemHandler;
import harrypotter.items.WandItem;
import harrypotter.items.spellbooks.AguamentiSpellbock;
import harrypotter.items.spellbooks.ExpelliamusSpellbock;
import harrypotter.items.spellbooks.IncendioSpellbock;
import harrypotter.items.spellbooks.LumosSpellBock;
import harrypotter.items.spellbooks.NoxSpellbock;
import harrypotter.items.spellbooks.StuporSpellbock;
import harrypotter.listener.ProjectileListener;

public class HarryPotterPlugin extends JavaPlugin {
	
	public static HarryPotterPlugin plugin;
	
	private static ArrayList<Player> projectilePlayers = new ArrayList<>();
	public static ArrayList<Player> getProjectilePlayers() {
		return projectilePlayers;
	}
	
	
	@Override
	public void onEnable() {
		plugin = this;
		
		registerCommands();
		registerEvents();
		registerItems();
		registerCraftingRecipies();
	}
	
	private void registerCommands() {
		getCommand("harrypotter").setExecutor(new ItemCommand());
	}
	
	private void registerEvents() {
		PluginManager manager = Bukkit.getServer().getPluginManager();
		
		manager.registerEvents(new ItemHandler(), this);
		manager.registerEvents(new ProjectileListener(), this);
	}
	
	private void registerItems() {
		ItemHandler.registerItem(new WandItem());
		ItemHandler.registerItem(new StuporSpellbock());
		ItemHandler.registerItem(new ExpelliamusSpellbock());
		ItemHandler.registerItem(new LumosSpellBock());
		ItemHandler.registerItem(new NoxSpellbock());
		ItemHandler.registerItem(new AguamentiSpellbock());
		ItemHandler.registerItem(new IncendioSpellbock());
	}
	
	@SuppressWarnings("deprecation")
	private void registerCraftingRecipies() {
		ShapedRecipe shapedrecipe = new ShapedRecipe(new WandItem().getItem()).shape("xxd","xsx","sxx").setIngredient('x', Material.AIR).setIngredient('s', Material.STICK).setIngredient('d', Material.DIAMOND);
		getServer().addRecipe(shapedrecipe);
	}
}