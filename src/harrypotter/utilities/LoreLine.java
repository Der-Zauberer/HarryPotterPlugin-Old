package harrypotter.utilities;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LoreLine {
	
	static String text;
	static ItemStack item;
	static Lore lore;
	
	private static LoreLine lineClass;
	
	public LoreLine(Lore itemLore, ItemStack itemStack, String lineText) {
		lore = itemLore;
		item = itemStack;
		text = lineText;
	}
	
	public static LoreLine getLine(Lore itemLore, ItemStack itemStack, String lineText) {
		if (itemStack != null && itemStack.getType() != null && itemStack.getType() != Material.AIR && itemStack.getItemMeta() != null) {
			if (itemStack.getItemMeta().getLore() != null || !itemStack.getItemMeta().getLore().isEmpty()) {
				lineClass = new LoreLine(itemLore, itemStack, lineText);
				return lineClass;
			}
		}
		return null;
	}
	
	public static void replace(String newText) {
		List<String> entries = Lore.getLoreList();
		entries.set(Lore.getLoreList().indexOf(text), newText);
		ItemMeta meta = item.getItemMeta();
		meta.setLore(entries);
		item.setItemMeta(meta);
	}
	
	public static void set(String newText) {
		List<String> entries = Lore.getLoreList();
		entries.set(Lore.getLoreList().indexOf(text), newText);
		ItemMeta meta = item.getItemMeta();
		meta.setLore(entries);
		item.setItemMeta(meta);
	}
	
	public static void clearLine() {
		List<String> entries = Lore.getLoreList();
		entries.remove(text);
		ItemMeta meta = item.getItemMeta();
		meta.setLore(entries);
		item.setItemMeta(meta);
	}
}