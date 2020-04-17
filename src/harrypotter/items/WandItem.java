package harrypotter.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import harrypotter.utilities.ItemBuilder;
import harrypotter.utilities.UsableItem;

public class WandItem implements UsableItem {
	
	private Player owner;
	
	@Override
	public ItemStack getItem() {
		ItemBuilder itembuilder = new ItemBuilder(ChatColor.RESET + "Wand", Material.CARROT_ON_A_STICK);
		itembuilder.setCustomModelData(1);
		String lore[] = {"", ChatColor.GRAY + "Right-click item to set user!"};
		itembuilder.setLore(lore);
		return itembuilder.buildItem();
	}

	@Override
	public void onItemUse(Player player, ItemStack itemstack, Action action) {
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(owner == null) {
				owner = player;
				String lore[] = {"", ChatColor.RESET + "Owner:", ChatColor.GRAY + "Der_Zauberer"};
				ItemBuilder.setItemLore(itemstack, lore);
			} else if(owner == player) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20, 3));
			} else if(owner != player) {
				return;
			}
		}
	}

}
