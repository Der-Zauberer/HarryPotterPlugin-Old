package harrypotter.main;

import java.util.ArrayList;
import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;
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

	public static String prefix = "";
	
	@Override
	public void onEnable() {
		new Config();

		if (Config.getLanguageFile() == null || !Config.getLanguageFile().exists()) {
			Bukkit.getConsoleSender().sendMessage("[HarryPotter] Error while loading language file. Plugin is disabling ...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}

		if (Config.getLanguage() == null) {
			Bukkit.getConsoleSender().sendMessage("[HarryPotter] Error while loading language configuration. Plugin is disabling ...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}

		if (Config.getLanguage().getString("prefix") == null) {
			Bukkit.getConsoleSender().sendMessage("[HarryPotter] Error while loading prefix. Plugin is disabling ...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}

		prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Config.getLanguage().getString("prefix")));

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
		Bukkit.getPluginManager().registerEvents(new ItemHandler(), this);
		Bukkit.getPluginManager().registerEvents(new ProjectileListener(), this);
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
	
	public static ArrayList<Player> getProjectilePlayers() {
		return projectilePlayers;
	}
}