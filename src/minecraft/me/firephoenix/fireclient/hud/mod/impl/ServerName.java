package me.firephoenix.fireclient.hud.mod.impl;

import me.firephoenix.fireclient.hud.mod.HudMod;
import net.minecraft.client.gui.*;

public class ServerName extends HudMod {

	public ServerName() {
		super("ServerName", 140, 120);
	}

	@Override
	public void draw() {
		if (mc.getCurrentServerData() != null) {
			fr.drawString("Server:" + " " + mc.getCurrentServerData().serverIP, getX(), getY(), -1);
			super.draw();
		}
	}

	@Override
	public void renderDummy(int mouseX, int mouseY) {
		if (mc.getCurrentServerData() != null) {
			fr.drawString("Server:" + " " + mc.getCurrentServerData().serverIP, getX(), getY(), -1);
			super.renderDummy(mouseX, mouseY);
		}
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("Server:");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
