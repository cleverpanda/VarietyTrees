package panda.varietytrees.blocks;

import panda.varietytrees.util.IOreDictionaryEntry;
import panda.varietytrees.util.WoodMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.init.Blocks;

public class BlockVarietyStairs extends BlockStairs implements IOreDictionaryEntry{

	final WoodMaterial wood;


	public BlockVarietyStairs(WoodMaterial wood, Block modelBlock) {
		super(modelBlock.getDefaultState());
		this.setSoundType(SoundType.WOOD);
		this.wood = wood;
		this.blockHardness = wood.getPlankBlockHardness();
		this.blockResistance = wood.getBlastResistance();
		this.setHarvestLevel("axe", wood.getRequiredHarvestLevel());
		Blocks.FIRE.setFireInfo(this, 5, 20);
	}


	public WoodMaterial getMetalMaterial() {
		return this.wood;
	}

@Override
	public String getOreDictionaryName() {
		return "stairs" + this.wood.getCapitalizedName();
	}
}