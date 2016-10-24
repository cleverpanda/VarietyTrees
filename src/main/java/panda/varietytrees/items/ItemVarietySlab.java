package panda.varietytrees.items;

import panda.varietytrees.util.IOreDictionaryEntry;
import panda.varietytrees.util.WoodMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;


public class ItemVarietySlab extends ItemSlab implements IOreDictionaryEntry{

	final WoodMaterial wood;

	public ItemVarietySlab(WoodMaterial wood, Block block, BlockSlab slab, BlockSlab doubleslab) {
		super(block, slab, doubleslab);
		this.wood = wood;
	}

	public WoodMaterial getWoodMaterial() {
		return this.wood;
	}
@Override
	public String getOreDictionaryName() {
		return "slab" + this.wood.getCapitalizedName();
	}
}