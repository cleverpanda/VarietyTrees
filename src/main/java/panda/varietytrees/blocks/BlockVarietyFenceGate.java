package panda.varietytrees.blocks;

import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import panda.varietytrees.util.IOreDictionaryEntry;
import panda.varietytrees.util.WoodMaterial;

public class BlockVarietyFenceGate extends BlockFenceGate implements IOreDictionaryEntry{

	final WoodMaterial wood;


	public BlockVarietyFenceGate(WoodMaterial wood) {
		//TODO maptypes
		super(BlockPlanks.EnumType.OAK);
		this.setSoundType(SoundType.WOOD);
		this.wood = wood;
		this.blockHardness = wood.getPlankBlockHardness();
		this.blockResistance = wood.getBlastResistance();
		this.setHarvestLevel("axe", wood.getRequiredHarvestLevel());
		Blocks.FIRE.setFireInfo(this, 5, 20);
	}

	/*@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		list.add(new ItemStack(itemIn, 1, BlockFence..EnumType.NORMAL.getMetadata()));
	}*/


	public WoodMaterial getWoodMaterial() {
		return this.wood;
	}

@Override
	public String getOreDictionaryName() {
		return "gate" + this.wood.getCapitalizedName();
	}
}