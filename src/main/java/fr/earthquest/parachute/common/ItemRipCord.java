package fr.earthquest.parachute.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRipCord extends Item {

	public ItemRipCord()
	{
		super();
		maxStackSize = 1;
		setMaxDamage(ToolMaterial.IRON.getMaxUses());
		setCreativeTab(CreativeTabs.tabTools); // place in the tools tab in creative mode
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		if (Parachute.playerIsWearingParachute(entityPlayer) && !entityPlayer.onGround && !entityPlayer.isOnLadder()) {
			ItemStack itemstack = entityPlayer.getCurrentArmor(Parachute.armorSlot);
			((ItemParachute) itemstack.getItem()).deployParachute(world, entityPlayer);
			if (!entityPlayer.capabilities.isCreativeMode) {
				itemStack.damageItem(1, entityPlayer);
			}
		}
		return itemStack;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconReg)
	{
		super.registerIcons(iconReg);
		itemIcon = iconReg.registerIcon(Parachute.modid.toLowerCase() + ":Ripcord");
	}

	@Override
	public boolean getIsRepairable(ItemStack itemstack1, ItemStack itemstack2)
	{
		return Items.iron_ingot == itemstack2.getItem() ? true : super.getIsRepairable(itemstack1, itemstack2);
	}

}
