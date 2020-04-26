package harrypotter.items.spellbooks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import harrypotter.handler.SpellHandler;
import harrypotter.handler.SpellHandler.Spell;
import harrypotter.utilities.ItemBuilder;
import harrypotter.utilities.UsableItem;

public class LumosSpellBock implements UsableItem {

	@Override
	public ItemStack getItem() {
		ItemBuilder itembuilder = new ItemBuilder("Lumos Spellbock", Material.BOOK);
		itembuilder.setCustomModelData(4);
		String lore[] = {"", ChatColor.GRAY + "Right-click to learn spell!"};
		itembuilder.setLore(lore);
		return itembuilder.buildItem();
	}
	
	@Override
	public void onItemUse(Player player, ItemStack itemstack, Action action) {
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			SpellHandler.addPlayerSpell(player, Spell.LUMOS);
		}
	}

}
