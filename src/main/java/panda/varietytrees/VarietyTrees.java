package panda.varietytrees;

import panda.varietytrees.blocks.BlockVarietyDoor;
import panda.varietytrees.blocks.BlockVarietyLeaves;
import panda.varietytrees.blocks.BlockVarietyLog;
import panda.varietytrees.proxy.Proxy;
import panda.varietytrees.proxy.ProxyClient;
import panda.varietytrees.util.BlockBreakHandler;
import panda.varietytrees.util.ConfigurationHandler;
import panda.varietytrees.versionchecker.OnJoinWorldHandler;
import panda.varietytrees.versionchecker.VersionChecker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = VarietyTrees.MODID, name = VarietyTrees.NAME, version = VarietyTrees.VERSION)


public class VarietyTrees
{
    public static final String MODID = "varietytrees";
    public static final String VERSION = "0.85";
    public static final String NAME = "Variety Trees";
    public static final String DEPENDENCIES = "Variety Trees";
    @SidedProxy(serverSide = "panda.varietytrees.proxy.Proxy", clientSide = "panda.varietytrees.proxy.ProxyClient")
    public static ProxyClient proxy;
    
	public static boolean haveWarnedVersionOutOfDate;
	public static VersionChecker versionChecker;

	public static ProxyClient PROXY = null;
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new BlockBreakHandler());
    	 MinecraftForge.EVENT_BUS.register(new OnJoinWorldHandler());
    	panda.varietytrees.init.Materials.init();
    	panda.varietytrees.init.Blocks.init();
    	panda.varietytrees.init.Items.init();
    	ConfigurationHandler.init(event);
        
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    { 
    	panda.varietytrees.init.Recipes.init();
    	proxy.init();
    	MinecraftForge.EVENT_BUS.register(this);
    }  


}