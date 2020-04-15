package harrypotter.handler;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import harrypotter.utilities.PlayerInventory;
import harrypotter.utilities.PlayerInventory.ItemOption;

public class InventoryHandler implements Listener {
	
	private static ArrayList<PlayerInventory> inventorymenus = new ArrayList<>();
	
	public static void addInventory(PlayerInventory inventory) {
		inventorymenus.add(inventory);
	}
	
	public static void removeInventory(PlayerInventory inventory) {
		inventorymenus.remove(inventory);
	}
	
	@EventHandler
	public void onInventoryClicked(InventoryClickEvent event) {
		if(event.getCurrentItem() != null) {
			for(PlayerInventory playerinventory : inventorymenus) {
				if(playerinventory.getInventory() == event.getClickedInventory() && playerinventory.getItemOption() == ItemOption.FIXED) {
					playerinventory.onItemClicked(event.getCurrentItem(), (Player) event.getWhoClicked());
					event.setCancelled(true);
				}
			}
		}
	}

}
