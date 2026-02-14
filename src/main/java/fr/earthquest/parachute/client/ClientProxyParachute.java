package fr.earthquest.parachute.client;

//import com.parachute.common.AADTick;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.earthquest.parachute.common.CommonProxyParachute;
import fr.earthquest.parachute.common.EntityParachute;
import fr.earthquest.parachute.common.KeyPressTick;

public class ClientProxyParachute extends CommonProxyParachute {

	@Override
	public void registerRenderer()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityParachute.class, new RenderParachute());
	}

	@Override
	public int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}
	
	@Override
	public void registerHandlers()
	{
		FMLCommonHandler.instance().bus().register(new KeyPressTick());
		
		// allow this mod to load if there are missing mappings
//		FMLClientHandler.instance().setDefaultMissingAction(FMLMissingMappingsEvent.Action.IGNORE);
	}

}
