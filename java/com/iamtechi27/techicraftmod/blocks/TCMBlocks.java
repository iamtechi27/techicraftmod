package com.iamtechi27.techicraftmod.blocks;

import net.minecraft.block.Block;

public class TCMBlocks {

	public static Block bonepile;
	public static Block obsidianpressureplate;
	public static Block invisiblepressureplate;
	public static Block crystaltorch;
	
	public static void init() {
		
		bonepile = new BlockBonePile();
		obsidianpressureplate = new BlockObsidianPressurePlate();
		invisiblepressureplate = new BlockInvisiblePressurePlate();
		crystaltorch = new BlockCrystalTorch();
		
	}
	
}
