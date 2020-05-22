package harrypotter.listener;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import harrypotter.main.HarryPotterPlugin;

public class ProjectileListener implements Listener {
	
	private int task;
	
	@EventHandler
	public void onLaunch(ProjectileLaunchEvent event) {
		if (event.getEntity() instanceof WitherSkull && event.getEntity().getShooter() != null && event.getEntity().getShooter() instanceof Player) {
			Player player = (Player) event.getEntity().getShooter();
			if (HarryPotterPlugin.getProjectilePlayers().contains(player)) {
				System.out.println(HarryPotterPlugin.getProjectilePlayers().size());
				task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HarryPotterPlugin.plugin, new Runnable() {
					@Override
					public void run() {
						Location location = event.getEntity().getLocation();
						World  world = location.getWorld();
						Particle.DustOptions dustOptions = new Particle.DustOptions(Color.ORANGE, 2);
						world.spawnParticle(Particle.REDSTONE, location.getY() + 4, 1, 1, 1, dustOptions);
					}
				}, 0, 10);
			}
		}
	}
	
	@EventHandler
	public void onHit(ProjectileHitEvent event) {
		if (event.getEntity().getShooter() != null && event.getEntity().getShooter() instanceof Player) {
			Player player = (Player) event.getEntity().getShooter();
			HarryPotterPlugin.getProjectilePlayers().remove(player);
			Bukkit.getScheduler().cancelTask(task);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if(event.getEntity() != null && event.getDamager() != null && event.getDamager() instanceof WitherSkull) {
			event.setCancelled(true);
			LivingEntity entity = (LivingEntity) event.getEntity();
			entity.setHealth(entity.getHealth() - 6);
		}
	}
	
	
}