package me.firephoenix.fireclient.hud.mod.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.firephoenix.fireclient.hud.mod.HudMod;
import net.minecraft.util.MathHelper;

public class Velocity extends HudMod {
	private Object currentSpeed;

	public Velocity() {
		super("Velocity", 100, 100);
	}

	@Override
	public void draw() {
	    DecimalFormat f = new DecimalFormat("0.0");
		double velocityX = mc.thePlayer.posX - mc.thePlayer.prevPosX;
		double velocityZ = mc.thePlayer.posZ - mc.thePlayer.prevPosZ;
		currentSpeed = MathHelper.sqrt_double(velocityX * velocityX + velocityZ * velocityZ) * 20;
		fr.drawString(f.format(currentSpeed) + " " + "m/s", getX(), getY(), -1);
		super.draw();
	}

	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString("5" + " " + "m/s", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		String pattern = "hh:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		return fr.getStringWidth("Time" + " " + time);
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
}