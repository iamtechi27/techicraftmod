package com.iamtechi27.techicraftmod;

import com.iamtechi27.techicraftmod.blocks.TCMBlocks;
import com.iamtechi27.techicraftmod.command.TCMCommands;
import com.iamtechi27.techicraftmod.event.TCMEventHandler;
import com.iamtechi27.techicraftmod.items.TCMItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = techicraftmod.MODID, version = techicraftmod.VERSION)
public class techicraftmod {
	
	public static final String MODID = "techicraftmod";
    public static final String VERSION = "8JDB";
    
    @SidedProxy(clientSide="com.iamtechi27.techicraftmod.ClientProxy", serverSide="com.iamtechi27.techicraftmod.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	
    	TCMBlocks.init();
    	TCMItems.init();
    	TCMCrafting.init();
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    	proxy.postinit(event);
    	MinecraftForge.EVENT_BUS.register(new TCMEventHandler());
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    	event.registerServerCommand(new TCMCommands());
    }
    
}
