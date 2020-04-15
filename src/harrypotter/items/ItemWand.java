package harrypotter.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import harrypotter.utilities.ItemBuilder;
import harrypotter.utilities.ItemFunction;

public class ItemWand implements ItemFunction {
	
	public static ItemStack getItem() {
		ItemBuilder itembuilder = new ItemBuilder(ChatColor.RESET + "Wand", Material.CARROT_ON_A_STICK);
		itembuilder.setCustomModelData(1);
		return itembuilder.buildItem();
	}

	@Override
	public void onItemUse(Player player, ItemStack itemstack, Action action) {
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 3));
		}
	}

	@Override
	public Material getType() {
		return Material.CARROT_ON_A_STICK;
	}

	@Override
	public int getCustomModelData() {
		return 1;
	}

}
