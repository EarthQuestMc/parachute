package fr.earthquest.parachute.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;

// intercept the space bar to make the parachute go up

@SideOnly(Side.CLIENT)
public class KeyPressTick {

	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event)
	{
		if (event.phase.equals(TickEvent.Phase.START)) {
			if (Keyboard.getEventKey() == Keyboard.KEY_SPACE) {
				EntityPlayer player = event.player;
				if (player != null) {
					boolean keyPressed = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
//					int playerID = player.getEntityId();
//					Parachute.packetPipeline.sendToServer(new ParachutePacket(Keyboard.KEY_SPACE, keyPressed, playerID));
					PacketHandler.INSTANCE.sendToServer(new KeyPressMessage(Keyboard.KEY_SPACE, keyPressed));
				}
			}
		}
	}
	
}
