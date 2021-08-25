package me.firephoenix.fireclient.hud.mod.impl;

import me.firephoenix.fireclient.hud.mod.HudMod;
import me.firephoenix.fireclient.settings.BooleanSetting;
import me.firephoenix.fireclient.settings.ModeSetting;

public class TestMod extends HudMod{
	
	BooleanSetting test = new BooleanSetting("Test", true);
	ModeSetting testMode = new ModeSetting("Test Mode", "Mode1", "Mode2", "Mode3");

	public TestMod() {
		super("testMod", 5, 5);
	}
	
	@Override
	public void draw() {
		fr.drawString(name, getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString(name, getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth(name);
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
}
