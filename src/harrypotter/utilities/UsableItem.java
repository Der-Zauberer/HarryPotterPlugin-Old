package harrypotter.utilities;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public interface UsableItem {
	
	public abstract void onItemUse(Player player, ItemStack itemstack, Action action);
	public abstract ItemStack getItem();

}
