package fr.earthquest.parachute.common;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;


public class PacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Parachute.modid.toLowerCase());
	
	public static void init()
	{
		INSTANCE.registerMessage(KeyPressMessage.class, KeyPressMessage.class, 0, Side.SERVER);
	}
}
