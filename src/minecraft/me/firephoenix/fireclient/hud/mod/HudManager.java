package me.firephoenix.fireclient.hud.mod;

import java.awt.Color;
import java.util.ArrayList;

import me.firephoenix.fireclient.hud.mod.impl.ArmorStatus;
import me.firephoenix.fireclient.hud.mod.impl.CPSMod;
import me.firephoenix.fireclient.hud.mod.impl.CustomEnchantGlint;
import me.firephoenix.fireclient.hud.mod.impl.FPSMod;
import me.firephoenix.fireclient.hud.mod.impl.Keystrokes;
import me.firephoenix.fireclient.hud.mod.impl.PerspectiveMod;
import me.firephoenix.fireclient.hud.mod.impl.TestMod;

public class HudManager {

	public ArrayList<HudMod> hudMods = new ArrayList<>();

	public FPSMod fps;
	public Keystrokes keystrokes;
	public CPSMod cps;
	public CustomEnchantGlint customGlint;
	public PerspectiveMod perspective;
	public ArmorStatus armor;

	public HudManager() {

		hudMods.add(fps = new FPSMod());
		hudMods.add(keystrokes = new Keystrokes());
		hudMods.add(cps = new CPSMod());
		hudMods.add(customGlint = new CustomEnchantGlint());
		hudMods.add(perspective = new PerspectiveMod());
		hudMods.add(armor = new ArmorStatus());
	}
	
	
	
	public static CustomEnchantGlint getGlintColor() {
		CustomEnchantGlint glintColor = new CustomEnchantGlint();
		return glintColor;
	}

	public void renderMods() {
		for (HudMod m : hudMods) {
			if (m.isEnabled()) {
				m.draw();
			}
		}
	}

}
