package com.iamtechi27.techicraftmod.blocks;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSolidGlass extends BlockBreakable {

	public String name = "solidglass";
	
	public BlockSolidGlass() {
		super(Material.glass, false);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}

	
	public String getName(){
		return name;
	}
	
	@Override
    public boolean isOpaqueCube(){
        return false;
    }
	
	@Override
	public boolean isFullCube(){
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
	
}
