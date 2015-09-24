package com.iamtechi27.techicraftmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public boolean shouldSpawnBatsOnBreak;
	private EntityPlayer player;
	private World world;
	public static String EXT_PROP_NAME = "TCM_PROPS";
	

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		//System.out.println("[TCM PROPS] Saving data");
		NBTTagCompound properties = new NBTTagCompound();
		properties.setBoolean("shouldSpawnBatsOnBreak", shouldSpawnBatsOnBreak);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		if (compound == null) {
			this.shouldSpawnBatsOnBreak = false;
			this.saveNBTData(compound);
		}
		//System.out.println("[TCM PROPS] Loading data");
		NBTTagCompound properties = (NBTTagCompound)compound.getTag(EXT_PROP_NAME);
		this.shouldSpawnBatsOnBreak = properties.getBoolean("shouldSpawnBatsOnBreak");
		if (shouldSpawnBatsOnBreak) {
			System.out.println("[TCM PROPS] Spawning bats for: " + player.getDisplayNameString());
		}
	}

	@Override
	public void init(Entity entity, World world) {
		//System.out.println("init thingy?");
		this.player = (EntityPlayer) entity;
		this.world = world;
		
	}

	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer)player.getExtendedProperties(EXT_PROP_NAME);
	}
	
}
