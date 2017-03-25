package panda.varietytrees;

import panda.varietytrees.blocks.BlockVarietyPlanks;
import panda.varietytrees.events.ConsumedByFireListener;
import panda.varietytrees.generation.WorldGenerator;
import panda.varietytrees.init.Materials;
import panda.varietytrees.init.SpecialFire;
import panda.varietytrees.proxy.CommonProxy;
import panda.varietytrees.proxy.ProxyClient;
import panda.varietytrees.util.BlockBreakHandler;
import panda.varietytrees.util.ConfigurationHandler;
import panda.varietytrees.util.WoodMaterial;
import panda.varietytrees.versionchecker.VersionChecker;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ExistingSubstitutionException;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = VarietyTrees.MODID, name = VarietyTrees.NAME, version = VarietyTrees.VERSION)


public class VarietyTrees
{
	public static final String MODID = "varietytrees";
	public static final String VERSION = "0.98.2";
	//fixed issue regarding other mod's tree drops
	//fixed tree grid generation
	//cleaned up
	public static final String NAME = "Variety Trees";
	public static final String DEPENDENCIES = "Variety Trees";
	@SidedProxy(serverSide = "panda.varietytrees.proxy.ProxyServer", clientSide = "panda.varietytrees.proxy.ProxyClient")
	public static CommonProxy proxy;

	public static boolean haveWarnedVersionOutOfDate;
	public static VersionChecker versionChecker;

	public static ProxyClient PROXY = null;
	
	//maybe reextue stuff 
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new BlockBreakHandler());
		MinecraftForge.EVENT_BUS.register(new FireHandler());
		//MinecraftForge.EVENT_BUS.register(new OnJoinWorldHandler());
		panda.varietytrees.init.Materials.init();
		panda.varietytrees.init.Blocks.init();
		panda.varietytrees.init.Items.init();
		
		ConfigurationHandler.init(event);
		
		

	}

	@EventHandler
	public void init(FMLInitializationEvent event) throws ExistingSubstitutionException
	{ 
		panda.varietytrees.init.Recipes.init();
		proxy.init(event);
		//GameRegistry.addSubstitutionAlias("minecraft:fire", GameRegistry.Type.BLOCK,panda.varietytrees.init.Blocks.specialfire );
		GameRegistry.registerWorldGenerator(new WorldGenerator(), 0);
		MinecraftForge.EVENT_BUS.register(this);
		((SpecialFire) panda.varietytrees.init.Blocks.specialfire).init();
	}  
	
	

	
	public static final CreativeTabs TreeTab = new CreativeTabs(VarietyTrees.MODID) {
	    @Override public Item getTabIconItem() {
	        return panda.varietytrees.init.Items.oak_seed;
	    }
	};


}