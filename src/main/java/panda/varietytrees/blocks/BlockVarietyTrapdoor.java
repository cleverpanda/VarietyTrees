package panda.varietytrees.blocks;

import panda.varietytrees.util.IOreDictionaryEntry;
import panda.varietytrees.util.WoodMaterial;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlockVarietyTrapdoor extends net.minecraft.block.BlockTrapDoor implements IOreDictionaryEntry{

	private final WoodMaterial wood;
	private final String oreDict;

	public BlockVarietyTrapdoor(WoodMaterial wood) {
		super(Material.WOOD);
		this.wood = wood;
		this.oreDict = "trapdoor" + wood.getCapitalizedName();
		this.blockHardness = wood.getPlankBlockHardness();
		this.blockResistance = wood.getBlastResistance();
		this.blockSoundType = SoundType.WOOD;
		this.setHarvestLevel("axe", wood.getRequiredHarvestLevel());
		this.disableStats();
	}

	@Override
	public boolean onBlockActivated(final World world, final BlockPos coord, IBlockState state,
									final EntityPlayer player, EnumHand hand, ItemStack heldItem, final EnumFacing facing,
									final float partialX, final float partialY, final float partialZ) {
		if (this.wood.getToolHarvestLevel() > 1)
			return true;
		state = state.cycleProperty(BlockTrapDoor.OPEN);
		world.setBlockState(coord, state, 2);
		world.playEvent(player, ((Boolean) state.getValue(BlockTrapDoor.OPEN)) ? 1003 : 1006, coord, 0);
		return true;
	}
@Override
	public String getOreDictionaryName() {
		return this.oreDict;
	}

	public WoodMaterial getWoodMaterial() {
		return this.wood;
	}
}