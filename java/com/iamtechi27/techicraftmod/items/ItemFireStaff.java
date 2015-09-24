package com.iamtechi27.techicraftmod.items;

import com.iamtechi27.techicraftmod.entity.projectile.EntityStaffFireball;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFireStaff extends Item {

	private String name = "firestaff";
	private int cooldown = 50;
	private double posX, posY, posZ, accelX, accelY, accelZ;
	
	public ItemFireStaff() {
		
		this.setNoRepair();
		this.setMaxDamage(384);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
	@Override
	 public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.damageItem(1, player);
		if (!world.isRemote) {
			if (player.capabilities.isCreativeMode || cooldown == 50){
				this.posX = player.posX - (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * 0.32F);
		        this.posY = player.posY + player.getEyeHeight() - 0.10000000149011612D;
		        this.posZ = player.posZ - (double)(MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * 0.32F);
		        this.accelX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI));
		        this.accelZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI));
		        this.accelY = (double)(-MathHelper.sin(player.rotationPitch / 180.0F * (float)Math.PI));
				EntityStaffFireball fireball = new EntityStaffFireball(world, player, posX, posY, posZ, accelX, accelY, accelZ);
				player.worldObj.playSoundAtEntity(player, "mob.ghast.fireball", 1.0F, 1.0F);
				player.worldObj.spawnEntityInWorld(fireball);
				cooldown = 0;
			}
		}
		return itemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
	
	public String getName() {return name;}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (cooldown < 50 && !world.isRemote) {
			cooldown++;
		}
	}
	
}
