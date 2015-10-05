package com.iamtechi27.techicraftmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TCMBlocks {

	public static Block bonepile;
	public static Block obsidianpressureplate;
	public static Block invisiblepressureplate;
	public static Block crystaltorch;
	public static Block solidglass;
	
	public static void init() {
		
		bonepile = new BlockBonePile();
		obsidianpressureplate = new BlockObsidianPressurePlate();
		invisiblepressureplate = new BlockInvisiblePressurePlate();
		crystaltorch = new BlockCrystalTorch();
		solidglass = new BlockSolidGlass();
		
	}
	
}
