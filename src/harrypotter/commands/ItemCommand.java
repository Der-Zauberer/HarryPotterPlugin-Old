package harrypotter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import harrypotter.handler.ItemHandler;
import harrypotter.utilities.ItemMenu;
import harrypotter.utilities.PlayerInventory;
import harrypotter.utilities.UsableItem;

public class ItemCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			PlayerInventory playerinventory = new PlayerInventory((Player) sender, 36, "Harry Potter");
			ItemMenu itemmenu = new ItemMenu();
			int counter = 0;
			for(UsableItem usableitem : ItemHandler.getUsableitems()) {
				itemmenu.addItem(counter, usableitem.getItem());
				counter++;
			}
			playerinventory.setItemMenu(itemmenu);
			playerinventory.open();
		}
		return true;
	}

}
