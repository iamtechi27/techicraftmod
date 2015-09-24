package com.iamtechi27.techicraftmod.blocks;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockInvisiblePressurePlate extends BlockPressurePlate {

	private String name = "invisiblepressureplate";
	
	public BlockInvisiblePressurePlate() {
		super(Material.rock, Sensitivity.MOBS);
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(2);
	}
	
	@Override
	public int getRenderType() {return -1;}
	
	public String getName() {return name;}
	
	@Override
	protected int computeRedstoneStrength(World world, BlockPos pos) {
		
		AxisAlignedBB axisalignedbb = this.getSensitiveAABB(pos);
        List list;
        list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, axisalignedbb);
        
        if (!list.isEmpty())
        {
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                Entity entity = (Entity)iterator.next();

                if (!entity.doesEntityNotTriggerPressurePlate() && entity instanceof EntityPlayer)
                {
                    return 15;
                }
            }
        }
        return 0;
	}
	
}
