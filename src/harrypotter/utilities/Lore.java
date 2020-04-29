package harrypotter.utilities;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Lore {
	
	static List<String> loreList;
	static ItemStack item;
	
	private static Lore loreClass;
	
	public Lore(List<String> stringLore, ItemStack itemStack) {
		loreList = stringLore;
		item = itemStack;
	}
	
	public static Lore loadlore(ItemStack itemStack) {
		if (itemStack != null && itemStack.getType() != null && itemStack.getType() != Material.AIR && itemStack.getItemMeta() != null) {
			List<String> lores;
			if (itemStack.getItemMeta().getLore() == null || itemStack.getItemMeta().getLore().isEmpty()) {
				lores = new ArrayList<>();
				loreClass = new Lore(lores, itemStack);
				return loreClass;
			} else {
				lores = itemStack.getItemMeta().getLore();
				loreClass = new Lore(lores, itemStack);
				return loreClass;
			}
		}
		return null;
	}
	
	public static List<String> getLoreList() {
		return loreList;
	}
	
	public static ItemStack getItem() {
		return item;
	}
	
	public static void addLoreLine(String text) {
		List<String> lore = getLoreList();
		lore.add(text);
		ItemMeta meta = getItem().getItemMeta();
		meta.setLore(lore);
		getItem().setItemMeta(meta);
	}
	
	public static void removeLoreLine(String text) {
		List<String> lore = getLoreList();
		lore.remove(text);
		ItemMeta meta = getItem().getItemMeta();
		meta.setLore(lore);
		getItem().setItemMeta(meta);
	}
	
	public static void clearLines() {
		List<String> lore = getLoreList();
		lore.clear();
		ItemMeta meta = getItem().getItemMeta();
		meta.setLore(lore);
		getItem().setItemMeta(meta);
	}
}