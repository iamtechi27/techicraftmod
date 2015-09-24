package com.iamtechi27.techicraftmod;

import com.iamtechi27.techicraftmod.blocks.TCMBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TCMCrafting {

	public static void init() {
		
		GameRegistry.addShapedRecipe(new ItemStack(TCMBlocks.bonepile), "###", "###", "###", '#', Items.bone);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone, 9), new ItemStack(TCMBlocks.bonepile, 1));
		GameRegistry.addShapedRecipe(new ItemStack(TCMBlocks.obsidianpressureplate), "##", '#', Blocks.obsidian);
		GameRegistry.addShapedRecipe(new ItemStack(TCMBlocks.invisiblepressureplate), "#$#", "$@$", "#$#", '#', Items.quartz, '$', Blocks.glass, '@', TCMBlocks.obsidianpressureplate);
		GameRegistry.addShapedRecipe(new ItemStack(TCMBlocks.crystaltorch, 2), "#$#", "$@$", "#$#", '#', Items.quartz, '$', Blocks.torch, '@', Blocks.glass);
		
	}
	
}
