package com.iamtechi27.techicraftmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCrystalTorch extends Block {

	private String name = "crystaltorch";
	
	protected BlockCrystalTorch() {
		
		super(Material.glass);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setLightLevel(1F);
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
		
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state){
        return null;
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
	public int getRenderType() {return -1;}

	public String getName(){
		return name;
	}
	
}

