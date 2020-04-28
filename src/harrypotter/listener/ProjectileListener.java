package harrypotter.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import harrypotter.main.HarryPotterPlugin;

public class ProjectileListener implements Listener {
	
	int task;
	
	@EventHandler
	public void onLaunch(ProjectileLaunchEvent event) {
		if (event.getEntity() instanceof WitherSkull && event.getEntity().getShooter() != null && event.getEntity().getShooter() instanceof Player) {
			
			Player player = (Player) event.getEntity().getShooter();
			
			if (HarryPotterPlugin.getProjectilePlayers().contains(player)) {
				task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HarryPotterPlugin.plugin, new Runnable() {
					
					// führt bei jedem GameTick die Kalkulation der Koordinaten durch
					
					@Override
					public void run() {
						Location location = event.getEntity().getLocation();
						World  world = location.getWorld();
						
						// 4 entspricht der Zahl die auf die Y Koordinate addiert wird
						
						world.spawnParticle(Particle.REDSTONE, location.getY() + 4, 1, 1, 1);
					}
				}, 0, 10);
			}
		}
	}
	
	@EventHandler
	public void onHit(ProjectileLaunchEvent event) {
		if (event.getEntity().getShooter() != null && event.getEntity().getShooter() instanceof Player) {
			Player player = (Player) event.getEntity().getShooter();
			HarryPotterPlugin.getProjectilePlayers().remove(player.getName());
			Bukkit.getScheduler().cancelTask(task);
		}
	}
}