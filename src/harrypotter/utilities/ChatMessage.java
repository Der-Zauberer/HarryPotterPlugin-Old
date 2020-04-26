package harrypotter.utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatMessage {
	
	private static ChatColor messagecolor = ChatColor.AQUA;
	private static ChatColor errorcolor = ChatColor.RED;
	private static String servername = "§7[§bDerZauberer.eu§7]";
	
	public static enum ErrorMessage{ONLYCONSOLE, ONLYPLAYER, NOPERMISSION, PLAYERNOTONLINE}
	
	public static void sendServerMessage(Player player, String message) {
		player.sendMessage(servername + messagecolor + " " + message);
	}
	
	public static void sendServerMessage(CommandSender sender, String message) {
		sender.sendMessage(servername + messagecolor + " " + message);
	}
	
	public static void sendServerErrorMessage(Player player, String message) {
		player.sendMessage(servername + errorcolor + " " + message);
	}
	
	public static void sendServerErrorMessage(CommandSender sender, String message) {
		sender.sendMessage(servername + errorcolor + " " + message);
	}
	
	public static void sendServerErrorMessage(CommandSender sender, ErrorMessage errormessage) {
		switch (errormessage) {
		case ONLYCONSOLE: sender.sendMessage(servername + errorcolor + " " + "Dieser Befehl kann nur von der Konsole ausgeführt werden!"); break;
		case ONLYPLAYER: sender.sendMessage(servername + errorcolor + " " + "Dieser Befehl kann nur von Spielern ausgeführt werden!"); break;
		case NOPERMISSION: sender.sendMessage(servername + errorcolor + " " + "Du hast keine Rechte dies zu tun!"); break;
		case PLAYERNOTONLINE: sender.sendMessage("Der Spieler ist nicht online!"); break;
		default: break;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void sendServerBroadcastMessage(String message) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(servername + messagecolor + message);
		}
		Bukkit.getConsoleSender().sendMessage(servername + messagecolor + message);
	}
	
	public static void sendServerBroadcastMessage(String message, Player player) {
		player.sendMessage(servername + messagecolor + message);
		Bukkit.getConsoleSender().sendMessage(servername + messagecolor + message);
	}
}
