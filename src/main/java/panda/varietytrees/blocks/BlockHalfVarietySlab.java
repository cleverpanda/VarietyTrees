package panda.varietytrees.blocks;

import panda.varietytrees.util.WoodMaterial;


public class BlockHalfVarietySlab extends BlockVarietySlab {

	public BlockHalfVarietySlab(WoodMaterial wood) {
		super(wood);
	}

	@Override
	public boolean isDouble() {
		return false;
	}
}
