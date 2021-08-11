package me.firephoenix.fireclient.cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;

public class CapeChecker {

	public static boolean ownsCape(AbstractClientPlayer entitylivingbaseIn) {
		if(entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE) && entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().thePlayer.getName())) {
			return true;
		}
		else return false;
	}
	
}
