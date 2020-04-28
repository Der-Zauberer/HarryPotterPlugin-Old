package harrypotter.handler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import harrypotter.main.Config;
import org.bukkit.ChatColor;

public class SpellHandler {
	
	public enum Spell{AGUAMENTI, EXPELLIARMUS, INCENDIO, LUMOS, NOX, STUPOR};
	
	public static boolean addPlayerSpell(Player player, Spell spell) {
		if(!hasPlayerSpell(player, spell)) {
			Config.addSpellToPlayer(player, spell);
			String spellname = spell.toString().toLowerCase();
			spellname = spellname.substring(0, 1).toUpperCase() + spellname.substring(1);
			if(Config.areAlertsEnabled()) {
				for(Player players : Bukkit.getOnlinePlayers()) {
					players.sendMessage(player.getName() + " has just learned a new spell " + ChatColor.BLUE + "[" + spellname + "]");
				}
			} else {
				player.sendMessage(player.getName() + " has just learned a new spell " + ChatColor.BLUE + "[" + spellname + "]");
			}
			return true;
		}
		return false;
	}
	
	public static boolean hasPlayerSpell(Player player, Spell spell) {
		return Config.hasPlayerSpell(player, spell);
	}
}
