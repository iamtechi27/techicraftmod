package com.iamtechi27.techicraftmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockBonePile extends Block{

	private String name = "bonepile";
	Random rand = new Random();
	private int damage;
	
	public BlockBonePile() {
		super(Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
		this.setHarvestLevel("shovel", 0);
		this.setHardness(0.7F);
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance) {
		
		if (entity.isSneaking())
        {
            entity.fall(fallDistance, 0.0F);
        }
        else
        {
        	entity.fall(fallDistance, 0.5F);
        }
		
	}

}
