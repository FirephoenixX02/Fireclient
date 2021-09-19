package me.firephoenix.fireclient.hud.mod.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.firephoenix.fireclient.hud.mod.HudMod;

public class Time extends HudMod {
	public Time() {
		super("Time", 100, 100);
	}

	@Override
	public void draw() {
		String pattern = "hh:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		fr.drawString("Time:" + " " + time, getX(), getY(), -1);
		super.draw();
	}

	@Override
	public void renderDummy(int mouseX, int mouseY) {
		String pattern = "hh:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		fr.drawString("Time:" + " " + time, getX(), getY(), -1);
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