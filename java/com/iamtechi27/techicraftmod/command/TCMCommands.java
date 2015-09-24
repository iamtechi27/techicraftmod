package com.iamtechi27.techicraftmod.command;

import com.iamtechi27.techicraftmod.entity.ExtendedPlayer;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class TCMCommands extends CommandBase {

	@Override
	public String getName() {
		return "tcm";
	}
	
	@Override
	public String getCommandUsage(ICommandSender sender) {
		//TODO actual command usage
		return "tcm";
	}
	
	@Override
	public void execute(ICommandSender sender, String[] arguments) throws PlayerNotFoundException {
		if (arguments[0].equals("ping")) {
			System.out.println("pong");
		}else if (arguments[0].equals("bats!")) {
			EntityPlayerMP entityplayermp = getPlayer(sender, arguments[1]);
			ExtendedPlayer.get(entityplayermp).shouldSpawnBatsOnBreak = true;
		}else if (arguments[0].equals("nobats")) {
			EntityPlayerMP entityplayermp = getPlayer(sender, arguments[1]);
			ExtendedPlayer.get(entityplayermp).shouldSpawnBatsOnBreak = false;
		}
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}
	
}
