package com.iamtechi27.techicraftmod;

import com.iamtechi27.techicraftmod.blocks.BlockBonePile;
import com.iamtechi27.techicraftmod.blocks.BlockCrystalTorch;
import com.iamtechi27.techicraftmod.blocks.BlockSolidGlass;
import com.iamtechi27.techicraftmod.blocks.BlockInvisiblePressurePlate;
import com.iamtechi27.techicraftmod.blocks.BlockObsidianPressurePlate;
import com.iamtechi27.techicraftmod.blocks.TCMBlocks;
import com.iamtechi27.techicraftmod.items.ItemFireStaff;
import com.iamtechi27.techicraftmod.items.TCMItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void preinit(FMLPreInitializationEvent event) {
		
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		
	}
	
	@Override
	public void postinit(FMLPostInitializationEvent event) {
		
		//rendering for items (includes blocks as items)
		
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		//blocks
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(TCMBlocks.bonepile), 0, new ModelResourceLocation(techicraftmod.MODID + ":" + ((BlockBonePile) TCMBlocks.bonepile).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(TCMBlocks.obsidianpressureplate), 0, new ModelResourceLocation(techicraftmod.MODID + ":" + ((BlockObsidianPressurePlate) TCMBlocks.obsidianpressureplate).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(TCMBlocks.invisiblepressureplate), 0, new ModelResourceLocation(techicraftmod.MODID + ":" + ((BlockInvisiblePressurePlate) TCMBlocks.invisiblepressureplate).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(TCMBlocks.crystaltorch), 0, new ModelResourceLocation(techicraftmod.MODID + ":" + ((BlockCrystalTorch) TCMBlocks.crystaltorch).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(TCMBlocks.solidglass), 0, new ModelResourceLocation(techicraftmod.MODID + ":" + ((BlockSolidGlass) TCMBlocks.solidglass).getName(), "inventory"));

		//items
		renderItem.getItemModelMesher().register(TCMItems.firestaff, 0, new ModelResourceLocation(techicraftmod.MODID + ":" + ((ItemFireStaff) TCMItems.firestaff).getName(), "inventory"));

	}
	
}
