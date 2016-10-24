package panda.varietytrees.blocks;

import panda.varietytrees.util.WoodMaterial;

public class BlockDoubleVarietySlab extends BlockVarietySlab {

	public BlockDoubleVarietySlab(WoodMaterial wood) {
		super(wood);
	}

	@Override
	public boolean isDouble() {
		return true;
	}
}
