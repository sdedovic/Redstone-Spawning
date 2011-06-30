package bandless55.RSpawn;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.CreatureType;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;
/**
 * RSpawn block listener
 * @author bandless55
 */
public class RSpawnBlockListener extends BlockListener {
    private final RSpawn plugin;

    public RSpawnBlockListener(final RSpawn plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here

/**
 * RSpawn block listener
 * 
 * @author bandless55
 */
	
	public void onBlockRedstoneChange(BlockRedstoneEvent event) {
		World world = event.getBlock().getWorld();
		int block1 = event.getBlock().getY(); 
		if (world.getBlockAt(event.getBlock().getX(),event.getBlock().getY() + 2, event.getBlock().getZ()).getType() == Material.MOB_SPAWNER) {

			Block spawnblock = world.getBlockAt(event.getBlock().getX(), event.getBlock().getY() + 3, event.getBlock().getZ());
			Location location = spawnblock.getLocation(); 

			if (RSpawn.checkpal(world.getBlockAt(event.getBlock().getX(), event.getBlock().getY() + 2, event.getBlock().getZ()).getLocation()) == true) {

				CreatureType mob = null; 
				int material = world.getBlockAt(event.getBlock().getX(),event.getBlock().getY() + 1, event.getBlock().getZ()).getTypeId();
				
				if(Files.RB == -1){
				
					if(material == Files.pig){
						mob = CreatureType.PIG; 
					}
					else if(material == Files.sheep){
						mob = CreatureType.SHEEP;
					}
					else if(material == Files.cow){
						mob = CreatureType.COW;
					}
					else if(material == Files.chicken){
						mob = CreatureType.CHICKEN;
					}
					else if(material == Files.squid){
						mob = CreatureType.SQUID;
					}
					else if(material == Files.pig_zombie){
						mob = CreatureType.PIG_ZOMBIE;
					}
					else if(material == Files.wolf){
						mob = CreatureType.WOLF;
					}
					else if(material == Files.ghast){
						mob = CreatureType.GHAST;
					}
					else if(material == Files.zombie){
						mob = CreatureType.ZOMBIE;
					}
					else if(material == Files.skeleton){
						mob = CreatureType.SKELETON;
					}
					else if(material == Files.spider){
						mob = CreatureType.SPIDER;
					}
					else if(material == Files.slime){
						mob = CreatureType.SLIME;
					}	
					else if(material == Files.creeper){
						mob = CreatureType.CREEPER;
					}
					else if(material == Files.human){
						mob = CreatureType.MONSTER;
					}
				
				
					
					if(mob != null){
						world.spawnCreature(location, mob);
					}
					else if(mob == null){
						return;
					}
				}
				
				
				if(Files.RB > 0){
					if(material == Files.RB){
					Random rand = new Random();
					int randint = -1;
					
					for(int count = 0; count < Files.RC; count++){
						 randint = rand.nextInt(7);
					
						if(randint == 0){
							mob = CreatureType.GHAST;
						}
						else if(randint == 1){
							mob = CreatureType.ZOMBIE;
						}
						else if(randint == 2){
							mob = CreatureType.SKELETON;
						}
						else if(randint == 3){
							mob = CreatureType.SPIDER;
						}
						else if(randint == 4){
							mob = CreatureType.SLIME;
						}
						else if(randint == 5){
							mob = CreatureType.CREEPER;
						}
						else if(randint == 6){
							mob = CreatureType.MONSTER;
						}
					
						world.spawnCreature(location, mob);
					}
					}
					
				}
					
			}

		}

	}
	

	// put all Block related code here
}
