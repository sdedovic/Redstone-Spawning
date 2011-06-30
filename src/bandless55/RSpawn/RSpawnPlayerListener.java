package bandless55.RSpawn;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

import bandless55.RSpawn.*;

/**
 * Handle events for all Player related events
 * @author bandless55
 */
public class RSpawnPlayerListener extends PlayerListener {
    private final RSpawn plugin;

    public RSpawnPlayerListener(RSpawn instance) {
        plugin = instance;
    }

public void onPlayerInteract(PlayerInteractEvent event) {
		
		
		
		boolean isair = event.isCancelled(); 
		if (isair == false) { 
		World world = event.getClickedBlock().getWorld();	

			if (event.getPlayer().getItemInHand().getTypeId() == Files.wand
					&& event.getClickedBlock().getType() == Material.MOB_SPAWNER) { // checks
																					// to
																					// see
																					// if
																					// you
																					// have
																					// a
																					// feather
																					// and
																					// you
																					// are
																					// hitting
																					// a
																					// mob
																					// spawner
				if (RSpawn.permissionHandler.has(event.getPlayer(),
						"rspawn") == true) { // checks to see if you have
												// permission using the
												// permissions plugin handler

					RSpawn.changepal(event.getClickedBlock().getLocation()); // this
																				// adds
																				// or
																				// removes
																				// the
																				// location
																				// from
																				// an
																				// arraylist
					event.getPlayer().sendMessage(
							"Spawning on Redstone is "
									+ RSpawn.checkpal(event
											.getClickedBlock().getLocation())); // this
																				// sends
																				// a
																				// message
																				// out
																				// to
																				// the
																				// user
				} else if (RSpawn.permissionHandler.has(event.getPlayer(),
						"RSpawn") == false) { // if the user doesnt have
													// permission to use the
													// plugin,
					event.getPlayer().sendMessage(
							"You Do Not Have Permission to Use This Pluggin"); // it
																				// notifies
																				// the
																				// user
				}
			}
			
			
			

		} else if (isair == true) {
			
			return;
		}

	}
}

