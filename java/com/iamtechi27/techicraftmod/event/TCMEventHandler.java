package com.iamtechi27.techicraftmod.event;

import com.iamtechi27.techicraftmod.techicraftmod;
import com.iamtechi27.techicraftmod.entity.ExtendedPlayer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TCMEventHandler {

	@SubscribeEvent
	public void onBlockBreak(BreakEvent event) {
		
		if (ExtendedPlayer.get(event.getPlayer()).shouldSpawnBatsOnBreak) {
		Entity entity = null;

        
        entity = EntityList.createEntityByID(65, event.world);

        if (entity instanceof EntityLivingBase)
        {
            EntityLiving entityliving = (EntityLiving)entity;
            entity.setLocationAndAngles(event.pos.getX() + 0.5D, event.pos.getY() + 0.5D, event.pos.getZ() + 0.5D, MathHelper.wrapAngleTo180_float(event.world.rand.nextFloat() * 360.0F), 0.0F);
            entityliving.rotationYawHead = entityliving.rotationYaw;
            entityliving.renderYawOffset = entityliving.rotationYaw;
            entityliving.func_180482_a(event.world.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
            event.world.spawnEntityInWorld(entity);
            entityliving.playLivingSound();
        }
		}
		
	}
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		
		if (event.entity instanceof EntityPlayer) {
		System.out.println("Entity Constructing");
		if (ExtendedPlayer.get((EntityPlayer)event.entity) != null) {
			return;
		}
		((EntityPlayer)event.entity).registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer());
		/*NBTTagCompound playerData = techicraftmod.proxy.getEntityData(((EntityPlayer) event.entity).getDisplayNameString());
		if (playerData != null) {
			ExtendedPlayer.get((EntityPlayer)event.entity).loadNBTData(playerData);
		}*/
		}
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = techicraftmod.proxy.getEntityData(((EntityPlayer)event.entity).getDisplayNameString());
			if (playerData != null) {
				ExtendedPlayer.get((EntityPlayer)event.entity).loadNBTData(playerData);
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (event.entity instanceof EntityPlayer) {
			//System.out.println("Entity Died");
			NBTTagCompound playerData = new NBTTagCompound();
			ExtendedPlayer.get((EntityPlayer)event.entity).saveNBTData(playerData);
			techicraftmod.proxy.storeEntityData(((EntityPlayer) event.entity).getDisplayNameString(), playerData);
		}
	}
	
}
