package harrypotter.items.spellbooks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import harrypotter.utilities.ItemBuilder;
import harrypotter.utilities.UsableItem;

public class NoxSpellbock implements UsableItem {
	
	@Override
	public ItemStack getItem() {
		ItemBuilder itembuilder = new ItemBuilder("Nox Spellbock", Material.BOOK);
		itembuilder.setCustomModelData(1);
		return itembuilder.buildItem();
	}
	
	@Override
	public void onItemUse(Player player, ItemStack itemstack, Action action) {
		
	}

}
