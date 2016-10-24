package panda.varietytrees.items;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import panda.varietytrees.init.Materials;
import panda.varietytrees.util.IOreDictionaryEntry;
import panda.varietytrees.util.WoodMaterial;

public class ItemVarietySeed extends Item implements IOreDictionaryEntry, IPlantable{
	
	final WoodMaterial wood;
	public final IBlockState sapling;
	
	public ItemVarietySeed(WoodMaterial wood)
    {
    	this.wood = wood;
    	this.sapling = getSaplingState();
    }
	
	/**
     * Called when a Block is right-clicked with this Item
     */
	@Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);

        if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && (state.getBlock()== net.minecraft.init.Blocks.GRASS ||state.getBlock()==net.minecraft.init.Blocks.DIRT|| state.getBlock()==net.minecraft.init.Blocks.FARMLAND) && worldIn.isAirBlock(pos.up()))
        {
        	worldIn.setBlockState(pos.up(), this.getSaplingState());
            --stack.stackSize;
            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }
	
	private IBlockState getSaplingState(){
		if(wood ==Materials.acacia || wood ==Materials.birch || wood ==Materials.darkOak || wood ==Materials.jungle || wood ==Materials.oak || wood ==Materials.spruce){
			return Blocks.SAPLING.getStateFromMeta(wood.getMeta());
		}else
			return GameRegistry.findBlock("varietytrees", wood+"_sapling").getDefaultState();		
	}

	@Override
	public String getOreDictionaryName() {
		return "seed" + this.wood.getCapitalizedName();
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return getSaplingState();
	}
}
