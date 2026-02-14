package fr.earthquest.parachute.common;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;


public class KeyPressMessage implements IMessage, IMessageHandler<KeyPressMessage, IMessage> {
	
	private boolean keyPressed;
	private int keyCode;
	
	public KeyPressMessage()
	{
		
	}
	
	public KeyPressMessage(int keyCode, boolean keyPressed)
	{
		this.keyCode = keyCode;
		this.keyPressed = keyPressed;
	}

	@Override
	public void fromBytes(ByteBuf bb)
	{
		keyCode = bb.readInt();
		keyPressed = bb.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf bb)
	{
		bb.writeInt(keyCode);
		bb.writeBoolean(keyPressed);
	}

	@Override
	public IMessage onMessage(KeyPressMessage msg, MessageContext mc)
	{
		EntityPlayer entityPlayer = mc.getServerHandler().playerEntity;
		if (entityPlayer != null) {
			if (msg.keyCode == Keyboard.KEY_SPACE) {
				EntityParachute.setAscendMode(msg.keyPressed);
			}
		}
		return null;
	}
	
}
