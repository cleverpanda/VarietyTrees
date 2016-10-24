package panda.varietytrees.versionchecker;

import panda.varietytrees.VarietyTrees;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import net.minecraft.client.gui.ChatLine;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class OnJoinWorldHandler {
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(PlayerTickEvent event)
    {
    	if (!VarietyTrees.haveWarnedVersionOutOfDate && event.player.worldObj.isRemote){
    		ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, 
                    "https://github.com/cleverpanda/VarietyTrees");
              Style clickableChatStyle = new Style().setClickEvent(versionCheckChatClickEvent);  //(0, (ITextComponent) versionCheckChatClickEvent, 0); //..setChatClickEvent(versionCheckChatClickEvent);
              TextComponentString versionWarningChatComponent = 
                    new TextComponentString("This build of Variety Trees is Alpha and not feature complete! There may be bugs. Click this message to go to the GitHub.");
              versionWarningChatComponent.setStyle(clickableChatStyle);
              
              event.player.addChatMessage(versionWarningChatComponent);
              VarietyTrees.haveWarnedVersionOutOfDate = true;
    	}
    	
    	
    	
    	
    	/*
        if (!VarietyTrees.haveWarnedVersionOutOfDate && event.player.worldObj.isRemote 
              && !VarietyTrees.versionChecker.isLatestVersion())
        {
            ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, 
                  "https://minecraft.curseforge.com/projects/birds-nests");
            Style clickableChatStyle = new Style().setClickEvent(versionCheckChatClickEvent);  //(0, (ITextComponent) versionCheckChatClickEvent, 0); //..setChatClickEvent(versionCheckChatClickEvent);
            TextComponentString versionWarningChatComponent = 
                  new TextComponentString("Your Bird's Nests Mod is not latest version!  Click this message to update.");
            versionWarningChatComponent.setStyle(clickableChatStyle);
            
            event.player.addChatMessage(versionWarningChatComponent);
            VarietyTrees.haveWarnedVersionOutOfDate = true;
        }*/
      
    }
}
