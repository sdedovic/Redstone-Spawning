package bandless55.RSpawn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

/**
 * RSpawn for Bukkit
 * 
 * @author bandless55
 */

public class RSpawn extends JavaPlugin {
	static ArrayList<Location> pal = new ArrayList<Location>(); // this stores
																// the locations
																// of enabled
																// spawners
	private final RSpawnPlayerListener playerListener = new RSpawnPlayerListener(this); // player listener
	private final RSpawnBlockListener blockListener = new RSpawnBlockListener(this); // block listener
	public static String pname = "Redstone Spawning";
	public static String pauthor = " [Bandless55] ";
	private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
	static PermissionHandler permissionHandler;
	private Logger log = Logger.getLogger("Minecraft");
	Plugin RSpawn; // my plugin object
	public static Server server; // the server object

	public void onEnable() {
		setupPermissions(); // permissions plugin
		Files.setup();
		Files.read_data();
		Files.read_prop();

		// Place any custom enable code here including the registration of any
		// events
		// Register our events
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvent(Type.REDSTONE_CHANGE, blockListener, Priority.Normal,
				this); // registers a STATE CHANGE, NOT if you place/remove
		pm.registerEvent(Type.PLAYER_INTERACT, playerListener, Priority.Normal,
				this); // registers any player interaction , ie. a left or

		// EXAMPLE: Custom code, here we just output some info so we can check
		// all is well
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println(pname + pauthor + "version " + pdfFile.getVersion()
				+ " is enabled!");

	}

	public void onDisable() {
		Files.write_data();

		// Place any custom disable code here

		// NOTE: All registered events are automatically unregistered when a
		// plugin is disabled

		// EXAMPLE: Custom code, here we just output some info so we can check
		// all is well
		System.out.println("Goodbye world!");
	}

	public boolean isDebugging(final Player player) {
		if (debugees.containsKey(player)) {
			return debugees.get(player);
		} else {
			return false;
		}
	}

	public void setDebugging(final Player player, final boolean value) {
		debugees.put(player, value);
	}

	public static void changepal(Location location) { // this method changes my
														// array list. if a
														// location is already
														// in the AL, then it
														// removes it. if a
														// location isnt in the
														// AL, it adds it.

		if (pal.contains(location) == true) {
			pal.remove(location);
		} else {
			pal.add(location);
		}
	}

	public static boolean checkpal(Location location) { // this method checks to
														// see if a location is
														// in the array list and
														// returns a boolean
		return pal.contains(location);
	}

	private void setupPermissions() { // this is for the permissions plugin
		Plugin permissionsPlugin = this.getServer().getPluginManager()
				.getPlugin("Permissions");

		if (this.permissionHandler == null) {
			if (permissionsPlugin != null) {
				this.permissionHandler = ((Permissions) permissionsPlugin)
						.getHandler();
			} else {
				log.info("Permission system not detected, defaulting to OP");
			}
		}
	}

}
