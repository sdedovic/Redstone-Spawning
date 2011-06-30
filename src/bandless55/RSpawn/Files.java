package bandless55.RSpawn;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Files {

	final static File dir = new File("plugins/" + RSpawn.pname);
	static File data = new File(dir, "data.txt");
	static File props = new File(dir, "config.properties");
	static String sepr = "-";
	static World world;
	public static Properties prop = new Properties();
	
	
	public static int wand;
	public static int pig;
	public static int sheep;
	public static int cow;
	public static int chicken;
	public static int squid;
	public static int pig_zombie;
	public static int wolf;
	public static int ghast;
	public static int zombie;
	public static int skeleton;
	public static int spider;
	public static int slime; 
	public static int creeper;
	public static int human;
	public static int RB;
	public static int RC;
	static String worldName; 
	
	
	static void setup(){
		
			if(!dir.exists()){
			dir.mkdir();
			System.out.println(RSpawn.pname + RSpawn.pauthor + "No Directory Found, Making One");
		}
			
			
		if(!data.exists()){
			try {
				data.createNewFile();
				System.out.println(RSpawn.pname + RSpawn.pauthor + "No Data File Found, Making One");
			} 
			catch (IOException e) {
				System.out.println(RSpawn.pname + RSpawn.pauthor + "Could Not Make Data File");
			}
		}
		
		if(!props.exists()){
			
			try {
				
				prop.setProperty("Wand-ID", "288");
				prop.setProperty("Pig", "-1");
				prop.setProperty("Sheep", "-1");
				prop.setProperty("Cow", "-1");
				prop.setProperty("Chicken", "-1");
				prop.setProperty("Squid", "-1");
				prop.setProperty("Pig_Zombie", "-1");
				prop.setProperty("Wolf", "-1");
				prop.setProperty("Ghast", "-1");
				prop.setProperty("Zombie", "87");
				prop.setProperty("Skeleton", "88");
				prop.setProperty("Spider", "89");
				prop.setProperty("Slime", "57");
				prop.setProperty("Creeper", "41");
				prop.setProperty("Human", "-1");
				prop.setProperty("Random-Block", "-1");
				prop.setProperty("Random-Count", "2");
				prop.setProperty("World-Name", "world");
				FileOutputStream out = new FileOutputStream(props);
				prop.store(out , "Wand-ID is set to feather. Mobs labeled '-1' do not spawn. Human mobs are very hostile. Random Blocks spawn Random Count amount of hostile mobs at once. This only works with enabled mobs.");
				System.out.println(RSpawn.pname + RSpawn.pauthor + "No Properties File Found, Making One");
			}
			catch(IOException e){
				System.out.println(RSpawn.pname + RSpawn.pauthor + "Could not Make Properties File");
			}
			
		}
		
	}
	
static void read_prop(){
		
		try {
			
			prop.load(new FileInputStream(props));
			
			wand = Integer.parseInt(prop.getProperty("Wand-ID"));
			pig = Integer.parseInt(prop.getProperty("Pig"));
			sheep = Integer.parseInt(prop.getProperty("Sheep"));
			cow = Integer.parseInt(prop.getProperty("Cow"));
			chicken = Integer.parseInt(prop.getProperty("Chicken"));
			squid = Integer.parseInt(prop.getProperty("Squid"));
			pig_zombie = Integer.parseInt(prop.getProperty("Pig_Zombie"));
			wolf = Integer.parseInt(prop.getProperty("Wolf"));
			ghast= Integer.parseInt(prop.getProperty("Ghast"));
			zombie = Integer.parseInt(prop.getProperty("Zombie"));
			skeleton = Integer.parseInt(prop.getProperty("Skeleton"));
			spider = Integer.parseInt(prop.getProperty("Spider"));
			slime = Integer.parseInt(prop.getProperty("Slime"));
			creeper = Integer.parseInt(prop.getProperty("Creeper"));
			human= Integer.parseInt(prop.getProperty("Human"));
			RB = Integer.parseInt(prop.getProperty("Random-Block"));
			RC= Integer.parseInt(prop.getProperty("Random-Count"));
			worldName = prop.getProperty("World-Name");
			
			
		} catch (FileNotFoundException e) {
			System.out.println(RSpawn.pname + RSpawn.pauthor + "Could Not Read Properties");
		} catch (IOException e) {
			System.out.println(RSpawn.pname + RSpawn.pauthor + "Could Not Read Properties");
		}
		
	}
	
	static void write_data(){
				
		try {
			PrintWriter out = new PrintWriter(new FileWriter(data));
			System.out.println(RSpawn.pname + RSpawn.pauthor + "Saving Data");
		 	for(int index = 0; index < RSpawn.pal.size(); index++){
		 		Location location = RSpawn.pal.get(index);
		 		String line = Integer.toString(location.getBlockX()) + sepr + Integer.toString(location.getBlockY()) + sepr + Integer.toString(location.getBlockZ());
		 		out.println(line);
		 	}
		 	out.close();
		 	System.out.println("\n" + RSpawn.pname + RSpawn.pauthor + "Data Saved");
		}
		catch (IOException e) {
			System.out.println("\n" + RSpawn.pname + RSpawn.pauthor + "Could not Save Data");
		}
	}
	
	static void read_data(){
		
		
		Block block; 
		try{
			FileInputStream fstream = new FileInputStream(data);
			DataInputStream dis = new DataInputStream(fstream);
			BufferedReader in = new BufferedReader(new InputStreamReader(dis));
			
			System.out.print(worldName);
			world = Bukkit.getServer().getWorld("world");
			
			String[] crd; 
			System.out.println(RSpawn.pname + RSpawn.pauthor + "Reading Data");
			String line;
			while((line = in.readLine()) != null){
				crd = line.split(sepr);
				block = world.getBlockAt(Integer.parseInt(crd[0]), Integer.parseInt(crd[1]), Integer.parseInt(crd[2]));
				RSpawn.pal.add(block.getLocation());
			}
			in.close();
			System.out.println(RSpawn.pname + RSpawn.pauthor + "Data Read");
		}
		catch(IOException e){
			System.out.println(RSpawn.pname + RSpawn.pauthor + "Could Not Read Data");
		} catch(NullPointerException e){
			
		}
		
	}
	
	
	
	
	
}

