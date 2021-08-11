package me.firephoenix.fireclient.hud.mod.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.lwjgl.input.Mouse;

import me.firephoenix.fireclient.hud.mod.HudMod;

public class CPSMod extends HudMod {

	private List<Long> clicks = new ArrayList<Long>();
	private List<Long> clicksrmb = new ArrayList<Long>();
	
	private boolean wasPressed;
	private long lastPressed;

	private boolean wasPressedrmb;
	private long lastPressedrmb;
	
	public CPSMod() {
		super("CPS", 150, 100);
	}

	@Override
	public void draw() {
		final boolean pressed = Mouse.isButtonDown(0);
		
		if(pressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis();
			this.wasPressed = pressed;
			if(pressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		final boolean pressedrmb = Mouse.isButtonDown(1);
		
		if(pressedrmb != this.wasPressedrmb) {
			this.lastPressedrmb = System.currentTimeMillis();
			this.wasPressedrmb = pressedrmb;
			if(pressedrmb) {
				this.clicksrmb.add(this.lastPressedrmb);
			}
		}
		fr.drawString(getCPS() + " | " + getCPSrmb() + " CPS", getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString(getCPS() + " | " + getCPSrmb() + " CPS", getX(), getY(), -1);

		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth("[" + mc.getDebugFPS() + " FPS]");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	private int getCPS() {
		final long time = System.currentTimeMillis();
		this.clicks.removeIf(new Predicate<Long>() {
			@Override
			public boolean test(Long aLong) {
				return aLong + 1000 < time;
			}
		});
		return this.clicks.size();
	}

	private int getCPSrmb() {
		final long timermb = System.currentTimeMillis();
		this.clicksrmb.removeIf(new Predicate<Long>() {
			@Override
			public boolean test(Long aLong) {
				return aLong + 1000 < timermb;
			}
		});
		return this.clicksrmb.size();
	}

	
}
