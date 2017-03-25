package panda.varietytrees;

import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import panda.varietytrees.events.ConsumedByFireListener;

public class FireHandler {
	@SubscribeEvent
	//@SideOnly(Side.SERVER)
    public void loadEvent(WorldEvent.Load event)
    {
		//System.out.println("doot");
		World world = event.getWorld();
		world.addEventListener(new ConsumedByFireListener());
    }
}
