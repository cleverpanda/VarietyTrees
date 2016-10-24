package panda.varietytrees.items;

import panda.varietytrees.util.IOreDictionaryEntry;
import panda.varietytrees.util.WoodMaterial;
import net.minecraft.block.BlockDoor;

/**
 * Doors
 */
public class ItemVarietyDoor extends net.minecraft.item.ItemDoor implements IOreDictionaryEntry{

	private final WoodMaterial wood;
	private final String oreDict;

	/**
	 *
	 * @param block
	 * @param metal
	 */
	public ItemVarietyDoor(BlockDoor block, WoodMaterial wood) {
		super(block);
		this.wood = wood;
		this.oreDict = "door" + wood.getCapitalizedName();
	}

@Override
	public String getOreDictionaryName() {
		return this.oreDict;
	}

	public WoodMaterial getWoodMaterial() {
		return this.wood;
	}
}