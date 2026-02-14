package fr.earthquest.parachute.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class AADTick {

	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event)
	{
		if (event.phase.equals(TickEvent.Phase.START) && event.side.isServer()) {
			onPlayerTick(event.player);
		}
	}

    // Handles the Automatic Activation Device
	// deploy the parachute if the player is at an altitude of Parachute.getAADAltitude()
	// and deactivate the AAD, consider it a one shot, you must re-activate it.
	private void onPlayerTick(EntityPlayer player)
	{
		if (Parachute.playerIsWearingParachute(player)) {
			ItemStack parachute = player.getCurrentArmor(Parachute.armorSlot);
			ItemStack aad = ItemAutoActivateDevice.inventoryContainsAAD(player.inventory);
			if (aad != null) {
				boolean auto = (!player.capabilities.isCreativeMode);
				boolean autoAltitudeReached = ItemAutoActivateDevice.getAutoActivateAltitude(player);
				if (auto && autoAltitudeReached && !player.onGround && !player.isOnLadder()) {
					((ItemParachute) parachute.getItem()).deployParachute(player.worldObj, player);
				}
			} // else fall to death!
		}
	}

}
