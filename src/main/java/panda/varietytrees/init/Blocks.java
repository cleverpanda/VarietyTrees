package panda.varietytrees.init;

import java.util.HashMap;
import java.util.Map;

















import panda.varietytrees.blocks.BlockDoubleVarietySlab;
import panda.varietytrees.blocks.BlockHalfVarietySlab;
import panda.varietytrees.blocks.BlockVarietyDoor;
import panda.varietytrees.blocks.BlockVarietyFence;
import panda.varietytrees.blocks.BlockVarietyFenceGate;
import panda.varietytrees.blocks.BlockVarietyLeaves;
import panda.varietytrees.blocks.BlockVarietyLog;
import panda.varietytrees.blocks.BlockVarietyPlanks;
import panda.varietytrees.blocks.BlockVarietySapling;
import panda.varietytrees.blocks.BlockVarietySlab;
import panda.varietytrees.blocks.BlockVarietyStairs;
import panda.varietytrees.blocks.BlockVarietyTrapdoor;
import panda.varietytrees.util.IOreDictionaryEntry;
import panda.varietytrees.util.WoodMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * This class initializes all blocks in Base Metals and provides some utility
 * methods for looking up blocks.
 *
 * @author DrCyano
 *
 */
public abstract class Blocks {

	public static Block apple_log;
	public static Block apple_planks;
	public static BlockDoor apple_door;
	public static Block apple_trapdoor;
	public static Block apple_leaves;
	public static Block apple_sapling;
	public static Block apple_gate;
	protected static BlockSlab apple_slab;
	protected static BlockSlab double_apple_slab;
	protected static Block apple_stairs;
	protected static Block apple_fence;
	
	public static Block maple_log;
	public static Block maple_planks;
	public static BlockDoor maple_door;
	public static Block maple_trapdoor;
	public static Block maple_leaves;
	public static Block maple_sapling;
	public static Block maple_gate;
	protected static BlockSlab maple_slab;
	protected static BlockSlab double_maple_slab;
	protected static Block maple_stairs;
	protected static Block maple_fence;
	
	public static Block pine_log;
	public static Block pine_planks;
	public static BlockDoor pine_door;
	public static Block pine_trapdoor;
	public static Block pine_leaves;
	public static Block pine_sapling;
	public static Block pine_gate;
	protected static BlockSlab pine_slab;
	protected static BlockSlab double_pine_slab;
	protected static Block pine_stairs;
	protected static Block pine_fence;
	
	public static Block willow_log;
	public static Block willow_planks;
	public static BlockDoor willow_door;
	public static Block willow_trapdoor;
	public static Block willow_leaves;
	public static Block willow_sapling;
	public static Block willow_gate;
	protected static BlockSlab willow_slab;
	protected static BlockSlab double_willow_slab;
	protected static Block willow_stairs;
	protected static Block willow_fence;
	
	public static Block yew_log;
	public static Block yew_planks;
	public static BlockDoor yew_door;
	public static Block yew_trapdoor;
	public static Block yew_leaves;
	public static Block yew_sapling;
	public static Block yew_gate;
	protected static BlockSlab yew_slab;
	protected static BlockSlab double_yew_slab;
	protected static Block yew_stairs;
	protected static Block yew_fence;
	
	public static Block ebony_log;
	public static Block ebony_planks;
	public static BlockDoor ebony_door;
	public static Block ebony_trapdoor;
	public static Block ebony_leaves;
	public static Block ebony_sapling;
	public static Block ebony_gate;
	protected static BlockSlab ebony_slab;
	protected static BlockSlab double_ebony_slab;
	protected static Block ebony_stairs;
	protected static Block ebony_fence;
	
	public static Block fir_log;
	public static Block fir_planks;
	public static BlockDoor fir_door;
	public static Block fir_trapdoor;
	public static Block fir_leaves;
	public static Block fir_sapling;
	public static Block fir_gate;
	protected static BlockSlab fir_slab;
	protected static BlockSlab double_fir_slab;
	protected static Block fir_stairs;
	protected static Block fir_fence;
	

	
	private static boolean initDone = false;

	private static Map<Block, String> allBlocks = new HashMap<>();
	private static final Map<String, Block> blockRegistry = new HashMap<>();


	/**
	 * Gets an block by its name. The name is the name as it is registered in
	 * the GameRegistry, not its unlocalized name (the unlocalized name is the
	 * registered name plus the prefix "varietytrees.")
	 * 
	 * @param name The name of the block in question
	 * @return The block matching that name, or null if there isn't one
	 */
	public static Block getBlockByName(String name) {
		return blockRegistry.get(name);
	}

	/**
	 * This is the reverse of the getBlockByName(...) method, returning the
	 * registered name of an block instance (Variety Trees blocks only).
	 * 
	 * @param b The item in question
	 * @return The name of the item, or null if the item is not a Variety Trees
	 * block.
	 */
	public static String getNameOfItem(Block b) {
		return allBlocks.get(b);
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone)
			return;

		panda.varietytrees.init.Materials.init();
		WoodMaterial mat = Materials.apple;
		apple_planks = createPlank(mat);
		apple_log = createLog(mat);
		apple_leaves = createLeaves(mat);
		apple_door = createDoor(mat);
		apple_trapdoor = createTrapDoor(mat);
		((BlockVarietyDoor) apple_door).setDoorItem(Items.apple_door);
		apple_slab = createSlab(mat);
		double_apple_slab = createDoubleSlab(mat);
		apple_stairs = createStairs(mat);
		apple_fence = createFence(mat);
		apple_sapling = createSapling(mat);
		apple_gate = createGate(mat);
		
		mat = Materials.maple;
		maple_planks = createPlank(mat);
		maple_log = createLog(mat);
		maple_leaves = createLeaves(mat);
		maple_door = createDoor(mat);
		maple_trapdoor = createTrapDoor(mat);
		((BlockVarietyDoor) maple_door).setDoorItem(Items.maple_door);
		maple_slab = createSlab(mat);
		double_maple_slab = createDoubleSlab(mat);
		maple_stairs = createStairs(mat);
		maple_fence = createFence(mat);
		maple_sapling = createSapling(mat);
		maple_gate = createGate(mat);
		
		mat = Materials.pine;
		pine_planks = createPlank(mat);
		pine_log = createLog(mat);
		pine_leaves = createLeaves(mat);
		pine_door = createDoor(mat);
		pine_trapdoor = createTrapDoor(mat);
		((BlockVarietyDoor) pine_door).setDoorItem(Items.pine_door);
		pine_slab = createSlab(mat);
		double_pine_slab = createDoubleSlab(mat);
		pine_stairs = createStairs(mat);
		pine_fence = createFence(mat);
		pine_sapling = createSapling(mat);
		pine_gate = createGate(mat);
		
		mat = Materials.willow;
		willow_planks = createPlank(mat);
		willow_log = createLog(mat);
		willow_leaves = createLeaves(mat);
		willow_door = createDoor(mat);
		willow_trapdoor = createTrapDoor(mat);
		((BlockVarietyDoor) willow_door).setDoorItem(Items.willow_door);
		willow_slab = createSlab(mat);
		double_willow_slab = createDoubleSlab(mat);
		willow_stairs = createStairs(mat);
		willow_fence = createFence(mat);
		willow_sapling = createSapling(mat);
		willow_gate = createGate(mat);
		
		mat = Materials.yew;
		yew_planks = createPlank(mat);
		yew_log = createLog(mat);
		yew_leaves = createLeaves(mat);
		yew_door = createDoor(mat);
		yew_trapdoor = createTrapDoor(mat);
		((BlockVarietyDoor) yew_door).setDoorItem(Items.yew_door);
		yew_slab = createSlab(mat);
		double_yew_slab = createDoubleSlab(mat);
		yew_stairs = createStairs(mat);
		yew_fence = createFence(mat);
		yew_sapling = createSapling(mat);
		yew_gate = createGate(mat);
		
		mat = Materials.ebony;
		ebony_planks = createPlank(mat);
		ebony_log = createLog(mat);
		ebony_leaves = createLeaves(mat);
		ebony_door = createDoor(mat);
		ebony_trapdoor = createTrapDoor(mat);
		((BlockVarietyDoor) ebony_door).setDoorItem(Items.ebony_door);
		ebony_slab = createSlab(mat);
		double_ebony_slab = createDoubleSlab(mat);
		ebony_stairs = createStairs(mat);
		ebony_fence = createFence(mat);
		ebony_sapling = createSapling(mat);
		ebony_gate = createGate(mat);
		
		mat = Materials.fir;
		fir_planks = createPlank(mat);
		fir_log = createLog(mat);
		fir_leaves = createLeaves(mat);
		fir_door = createDoor(mat);
		fir_trapdoor = createTrapDoor(mat);
		((BlockVarietyDoor) fir_door).setDoorItem(Items.fir_door);
		fir_slab = createSlab(mat);
		double_fir_slab = createDoubleSlab(mat);
		fir_stairs = createStairs(mat);
		fir_fence = createFence(mat);
		fir_sapling = createSapling(mat);
		fir_gate = createGate(mat);

		initDone = true;
	}

	private static Block addBlock(Block block, String name, WoodMaterial wood) {
		String fullName = null;

		if ((block instanceof BlockDoubleVarietySlab) && (wood != null))
			fullName = "double_" + wood.getName() + "_" + name;
		else if (block instanceof BlockDoubleVarietySlab)
			fullName = "double_" + name;
		else if (wood != null)
			fullName = wood.getName() + "_" + name;
		else
			fullName = name;

		block.setRegistryName(fullName);
		block.setUnlocalizedName(block.getRegistryName().getResourceDomain() + "." + fullName);
		GameRegistry.register(block);
		blockRegistry.put(fullName, block);
		allBlocks.put(block, fullName);

		if (!(block instanceof BlockVarietyDoor) && !(block instanceof BlockVarietySlab)) {
			final ItemBlock itemBlock = new ItemBlock(block);
			itemBlock.setRegistryName(fullName);
			itemBlock.setUnlocalizedName(block.getRegistryName().getResourceDomain() + "." + fullName);
			GameRegistry.register(itemBlock);
		}

		if (block instanceof BlockVarietyPlanks || block instanceof BlockVarietyLog|| block instanceof BlockHalfVarietySlab){
			block.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		}else
		if (block instanceof BlockVarietySapling || block instanceof BlockVarietyLeaves|| block instanceof BlockVarietyFence){
			block.setCreativeTab(CreativeTabs.DECORATIONS);
		}else
		if (block instanceof BlockVarietyFenceGate ){
			block.setCreativeTab(CreativeTabs.REDSTONE);
		}
			

		// TODO: Make this support multiple oredicts
		if (block instanceof IOreDictionaryEntry){
			OreDictionary.registerOre(((IOreDictionaryEntry) block).getOreDictionaryName(), block);
		}
			

		return block;
	}

	private static Block createPlank(WoodMaterial wood) {
		
		return addBlock(new BlockVarietyPlanks(wood), "planks", wood);
	}
	
	private static Block createLog(WoodMaterial wood) {
		return addBlock(new BlockVarietyLog(wood), "log", wood);
	}
	
	private static Block createSapling(WoodMaterial wood) {
		return addBlock(new BlockVarietySapling(wood), "sapling", wood);
	}
	
	private static Block createLeaves(WoodMaterial wood) {
		return addBlock(new BlockVarietyLeaves(wood), "leaves", wood);
	}

	private static BlockSlab createSlab(WoodMaterial wood) {
		return (BlockSlab) addBlock(new BlockHalfVarietySlab(wood), "slab", wood);
	}

	private static BlockSlab createDoubleSlab(WoodMaterial wood) {
		return (BlockSlab) addBlock(new BlockDoubleVarietySlab(wood), "slab", wood);
	}

	private static Block createStairs(WoodMaterial wood) {
		return addBlock(new BlockVarietyStairs(wood, Blocks.getBlockByName(wood.getName() + "_planks")), "stairs", wood);
	}

	private static Block createFence(WoodMaterial wood) {
		return addBlock(new BlockVarietyFence(wood), "fence", wood);
	}

	private static BlockDoor createDoor(WoodMaterial wood) {
		return (BlockDoor) addBlock(new BlockVarietyDoor(wood), "door", wood);
	}

	private static Block createTrapDoor(WoodMaterial wood) {
		return addBlock(new BlockVarietyTrapdoor(wood), "trapdoor", wood);
	}
	
	private static Block createGate(WoodMaterial wood) {
		return addBlock(new BlockVarietyFenceGate(wood), "fence_gate", wood);
		
	}

	public static Map<String, Block> getBlockRegistry() {
		return blockRegistry;
	}
}