package me.becja10.antiPortalTrap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;

public class AntiPortalTrap extends JavaPlugin implements Listener{
	
	public void onEnable() {
		System.out.println(getDescription().getName() + " version " + getDescription().getVersion() + " enabled.");
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	
	//possibly change this so that it checks blocks around the player as well, not just the one it's at.
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		Location loc = player.getEyeLocation();
		Block b = loc.getBlock();
		if(b.getType().equals(Material.PORTAL)){
			player.sendMessage(ChatColor.DARK_PURPLE + "Looks like you are trapped in a nether portal. Teleporting to spawn");
			player.performCommand("spawn");
		}		 
	}
	
}
