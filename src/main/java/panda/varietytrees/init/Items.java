package panda.varietytrees.init;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import panda.varietytrees.blocks.BlockDoubleVarietySlab;
import panda.varietytrees.blocks.BlockHalfVarietySlab;
import panda.varietytrees.blocks.BlockVarietyDoor;
import panda.varietytrees.blocks.BlockVarietyFence;
import panda.varietytrees.blocks.BlockVarietySlab;
import panda.varietytrees.blocks.BlockVarietyStairs;
import panda.varietytrees.blocks.BlockVarietyTrapdoor;
import panda.varietytrees.items.ItemVarietyDoor;
import panda.varietytrees.items.ItemVarietySeed;
import panda.varietytrees.items.ItemVarietySlab;
import panda.varietytrees.util.IOreDictionaryEntry;
import panda.varietytrees.util.WoodMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public abstract class Items {

	public static Item apple_door;
	public static Item apple_slab;
	public static Item apple_seed;
	
	public static Item maple_door;
	public static Item maple_slab;
	public static Item maple_seed;
	
	public static Item pine_door;
	public static Item pine_slab;
	public static Item pine_seed;
	
	public static Item willow_door;
	public static Item willow_slab;
	public static Item willow_seed;
	
	public static Item yew_door;
	public static Item yew_slab;
	public static Item yew_seed;
	
	public static Item ebony_door;
	public static Item ebony_slab;
	public static Item ebony_seed;
	
	public static Item fir_door;
	public static Item fir_slab;
	public static Item fir_seed;
	
	
	public static Item oak_seed;
	public static Item birch_seed;
	public static Item spruce_seed;
	public static Item dark_oak_seed;
	public static Item jungle_seed;
	public static Item acacia_seed;
	


	private static boolean initDone = false;

	private static Map<String, Item> itemRegistry = new HashMap<>();
	private static Map<Item, String> allItems = new HashMap<>();
	private static Map<WoodMaterial, List<Item>> itemsByWood = new HashMap<>();

	private static Map<BlockDoor, Item> doorMap = new HashMap<>();

	private static Map<Class<?>, Integer> classSortingValues = new HashMap<>();
	private static Map<WoodMaterial, Integer> materialSortingValues = new HashMap<>();

	/**
	 * Gets an item by its name. The name is the name as it is registered in the
	 * GameRegistry, not its unlocalized name (the unlocalized name is the
	 * registered name plus the prefix "basemetals.")
	 * 
	 * @param name The name of the item in question
	 * @return The item matching that name, or null if there isn't one
	 */
	public static Item getItemByName(String name) {
		return itemRegistry.get(name);
	}

	/**
	 * This is the reverse of the getItemByName(...) method, returning the
	 * registered name of an item instance (Base Metals items only).
	 * 
	 * @param i The item in question
	 * @return The name of the item, or null if the item is not a Base Metals
	 * item.
	 */
	public static String getNameOfItem(Item i) {
		return allItems.get(i);
	}

	/**
	 * Gets a map of all items added, sorted by metal
	 * 
	 * @return An unmodifiable map of added items catagorized by metal material
	 */
	public static Map<WoodMaterial, List<Item>> getItemsByWood() {
		return Collections.unmodifiableMap(itemsByWood);
	}

	// public static UniversalBucket universal_bucket; // now automatically added by Forge

	/**
	 * Gets the inventory item corresponding to a given door block
	 *
	 * @param b The door block
	 * @return The item that the player should use to place that kind of door
	 */
	public static Item getDoorItemForBlock(BlockVarietyDoor b) {
		return doorMap.get(b);
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone)
			return;

		panda.varietytrees.init.Blocks.init();


		
		apple_door = createDoor(Materials.apple, Blocks.apple_door);
		apple_slab = createSlab(Materials.apple, Blocks.apple_slab, Blocks.apple_slab, Blocks.double_apple_slab);
		apple_seed = createSeed(Materials.apple);
		
		maple_door = createDoor(Materials.maple, Blocks.maple_door);
		maple_slab = createSlab(Materials.maple, Blocks.maple_slab, Blocks.maple_slab, Blocks.double_maple_slab);
		maple_seed = createSeed(Materials.maple);
		
		pine_door = createDoor(Materials.pine, Blocks.pine_door);
		pine_slab = createSlab(Materials.pine, Blocks.pine_slab, Blocks.pine_slab, Blocks.double_pine_slab);
		pine_seed = createSeed(Materials.pine);
		
		willow_door = createDoor(Materials.willow, Blocks.willow_door);
		willow_slab = createSlab(Materials.willow, Blocks.willow_slab, Blocks.willow_slab, Blocks.double_willow_slab);
		willow_seed = createSeed(Materials.willow);
		
		yew_door = createDoor(Materials.yew, Blocks.yew_door);
		yew_slab = createSlab(Materials.yew, Blocks.yew_slab, Blocks.yew_slab, Blocks.double_yew_slab);
		yew_seed = createSeed(Materials.yew);
		
		ebony_door = createDoor(Materials.ebony, Blocks.ebony_door);
		ebony_slab = createSlab(Materials.ebony, Blocks.ebony_slab, Blocks.ebony_slab, Blocks.double_ebony_slab);
		ebony_seed = createSeed(Materials.ebony);
		
		fir_door = createDoor(Materials.fir, Blocks.fir_door);
		fir_slab = createSlab(Materials.fir, Blocks.fir_slab, Blocks.fir_slab, Blocks.double_fir_slab);
		fir_seed = createSeed(Materials.fir);
		
		oak_seed = createSeed(Materials.oak);
		birch_seed = createSeed(Materials.birch);
		spruce_seed = createSeed(Materials.spruce);
		dark_oak_seed = createSeed(Materials.darkOak);
		jungle_seed = createSeed(Materials.jungle);
		acacia_seed = createSeed(Materials.acacia);

		// TODO: Make this support multiple oredicts
		for (final Item i : allItems.keySet())
			if (i instanceof IOreDictionaryEntry)
				OreDictionary.registerOre(((IOreDictionaryEntry) i).getOreDictionaryName(), i);

		int ss = 0;
		//classSortingValues.put(BlockVarietyLog.class, ++ss * 10000);
		//classSortingValues.put(BlockVarietyPlank.class, ++ss * 10000);
		classSortingValues.put(BlockVarietyDoor.class, ++ss * 10000);
		classSortingValues.put(BlockVarietyTrapdoor.class, ++ss * 10000);
		classSortingValues.put(ItemVarietyDoor.class, classSortingValues.get(BlockVarietyDoor.class));

		classSortingValues.put(BlockVarietySlab.class, ++ss * 10000);
		classSortingValues.put(BlockDoubleVarietySlab.class, ++ss * 10000); // Probably not needed
		classSortingValues.put(BlockHalfVarietySlab.class, ++ss * 10000); // Probably not needed
		classSortingValues.put(BlockVarietyStairs.class, ++ss * 10000);
		classSortingValues.put(BlockVarietyFence.class, ++ss * 10000);
		classSortingValues.put(ItemVarietySlab.class, ++ss * 10000);

		final List<WoodMaterial> metlist = new ArrayList<>(Materials.getAllWoods().size());
		metlist.addAll(Materials.getAllWoods());
		metlist.sort((WoodMaterial a, WoodMaterial b) -> a.getName().compareToIgnoreCase(b.getName()));
		for (int i = 0; i < metlist.size(); i++)
			materialSortingValues.put(metlist.get(i), i * 100);

		initDone = true;
	}

	private static Item registerItem(Item item, String name, WoodMaterial wood, CreativeTabs tab) {
		String fullName = null;
		if (wood != null)
			fullName = wood.getName() + "_" + name;
		else
			fullName = name;

		item.setRegistryName(fullName);
		item.setUnlocalizedName(item.getRegistryName().getResourceDomain() + "." + fullName);
		GameRegistry.register(item);
		itemRegistry.put(fullName, item);
		allItems.put(item, fullName);

		if (tab != null)
			item.setCreativeTab(tab);

		if (wood != null) {
			itemsByWood.computeIfAbsent(wood, (WoodMaterial g) -> new ArrayList<>());
			itemsByWood.get(wood).add(item);
		}

		if (item instanceof IOreDictionaryEntry)
			OreDictionary.registerOre(((IOreDictionaryEntry) item).getOreDictionaryName(), item);

		return item;
	}

	private static Item createSlab(WoodMaterial wood, Block block, BlockSlab slab, BlockSlab doubleslab) {
		return registerItem(new ItemVarietySlab(wood, block, slab, doubleslab), "slab", wood, CreativeTabs.BUILDING_BLOCKS);
	}

	private static Item createDoor(WoodMaterial metal, BlockDoor door) {
		final Item item = new ItemVarietyDoor(door, metal);
		registerItem(item, "door", metal, CreativeTabs.REDSTONE);
		doorMap.put(door, item);
		return item;
	}
	
	private static Item createSeed(WoodMaterial wood) {
		return registerItem(new ItemVarietySeed(wood), "seed", wood, CreativeTabs.MATERIALS);
	}

	public static Map<String, Item> getItemRegistry() {
		return itemRegistry;
	}
}