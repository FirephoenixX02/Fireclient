package me.firephoenix.fireclient.hud.mod.impl;

import me.firephoenix.fireclient.hud.mod.HudMod;
import net.minecraft.client.gui.*;

public class Version extends HudMod{
	
	public Version() {
		super("Version", 140, 120);
	}
	
	@Override
	public void draw() {
	fr.drawString("Version:" + " " + mc.getCurrentServerData().gameVersion, getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
	fr.drawString("Version:" + " " + mc.getCurrentServerData().gameVersion, getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("Version:" + "");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
}
