package fr.earthquest.parachute.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingFallEvent;


public class PlayerFallEvent {
	
	public PlayerFallEvent()
	{
		Parachute.proxy.print("PlayerFallEvent ctor");
	}
	
	@SubscribeEvent
	public void onFallEvent(LivingFallEvent event)
	{
		EntityLivingBase rider = event.entityLiving;
		if (rider.ridingEntity instanceof EntityParachute) {
			rider.fallDistance = 0.0f;
			rider.isCollided = false;
			event.setCanceled(true);
		}
	}
}
