package panda.varietytrees.init;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



import panda.varietytrees.util.WoodMaterial;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLLog;

/**
 * This class initializes all of the metal materials in Base Metals. It also
 * contains utility methods for looking up materials by name and finding the
 * tool and armor material equivalents for a given metal.
 *
 * @author DrCyano
 *
 */
public abstract class Materials {

	private static Map<String, WoodMaterial> allMaterials = new HashMap<>();
	protected static List<WoodMaterial> materials = new LinkedList<WoodMaterial>();

	public static WoodMaterial apple;
	public static WoodMaterial maple;
	public static WoodMaterial pine;
	public static WoodMaterial willow;
	public static WoodMaterial yew;
	public static WoodMaterial ebony;
	public static WoodMaterial fir;
	
	
	
	//Vanilla woods
	public static WoodMaterial oak;
	public static WoodMaterial spruce;
	public static WoodMaterial darkOak;
	public static WoodMaterial jungle;
	public static WoodMaterial acacia;
	public static WoodMaterial birch;


	private static boolean initDone = false;

	/**
	 *
	 */
	public static void init() {
		if (initDone)
			return;


		apple = addMaterial("apple", 3, 2);
		maple = addMaterial("maple", 3, 2);
		pine = addMaterial("pine", 3, 2);
		willow = addMaterial("willow", 3, 2);
		yew = addMaterial("yew", 3, 2);
		ebony = addMaterial("ebony", 3, 2);
		fir = addMaterial("fir", 3, 2);
		
		
		oak = addMaterial("oak", 3,        2, 0);
		spruce = addMaterial("spruce",3,   2, 1);
		birch = addMaterial("birch", 3,    2, 2);
		jungle = addMaterial("jungle", 3,  2, 3);
		acacia = addMaterial("acacia", 3,  2, 4);
		darkOak = addMaterial("dark_oak",3,2, 5);
		
		


		initDone = true;
	}

	protected static WoodMaterial addMaterial(String name, double hardness, double strength, int meta) {
		final WoodMaterial m = new WoodMaterial(name, (float) hardness, (float) strength, meta);
		registerMaterial(name, m);

		materials.add(m);
		return m;
	}
	
	protected static WoodMaterial addMaterial(String name, double hardness, double strength) {
		final WoodMaterial m = new WoodMaterial(name, (float) hardness, (float) strength,0);
		registerMaterial(name, m);

		materials.add(m);
		return m;
	}

	protected static void registerMaterial(String name, WoodMaterial m) {

		allMaterials.put(name, m);
	}
	
	


	/**
	 * Returns a list of all metal materials in Base Metals. All of the metals
	 * in this list are also available as static public members of this class.
	 * 
	 * @return A Collection of MetalMaterial instances.
	 */
	public static Collection<WoodMaterial> getAllWoods() {
		return allMaterials.values();
	}

	/**
	 * Gets a metal material by its name (e.g. "copper").
	 * 
	 * @param metalName The name of a metal
	 * @return The material representing the named metal, or null if no metals
	 * have been registered under that name.
	 */
	public static WoodMaterial getWoodByName(String woodName) {
		return allMaterials.get(woodName);
	}
}