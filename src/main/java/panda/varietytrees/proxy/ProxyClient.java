package panda.varietytrees.proxy;

import panda.varietytrees.VarietyTrees;
import panda.varietytrees.init.Blocks;
import panda.varietytrees.init.Items;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ProxyClient extends Proxy{

	
	
	public void init() {
		final ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

		for (final String itemName : Items.getItemRegistry().keySet()) {
			final Item item = Items.getItemByName(itemName);
			itemModelMesher.register(item, 0, new ModelResourceLocation(new ResourceLocation(VarietyTrees.MODID, itemName), "inventory"));
		}

		for (final String blockName : Blocks.getBlockRegistry().keySet()) {
			final Block block = Blocks.getBlockByName(blockName);
			if (block instanceof BlockDoor)
				continue; // do not add door blocks
			itemModelMesher.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(VarietyTrees.MODID, blockName), "inventory"));
		}
	}

}
