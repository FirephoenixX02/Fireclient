package me.firephoenix.fireclient.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import me.firephoenix.fireclient.Fireclient;
import me.firephoenix.fireclient.ui.clickgui.comp.ModButton;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class ClickGUI extends GuiScreen{
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	@Override
	public void initGui() {
		super.initGui();
		this.modButtons.add(new ModButton(210, 60, 42, mc.fontRendererObj.FONT_HEIGHT + 5, Fireclient.INSTANCE.hudManager.fps));
		this.modButtons.add(new ModButton(240, 60, 42, mc.fontRendererObj.FONT_HEIGHT + 5, Fireclient.INSTANCE.hudManager.keystrokes));
		this.modButtons.add(new ModButton(330, 60, 42, mc.fontRendererObj.FONT_HEIGHT + 5, Fireclient.INSTANCE.hudManager.cps));
		this.modButtons.add(new ModButton(400, 60, 42, mc.fontRendererObj.FONT_HEIGHT + 5, Fireclient.INSTANCE.hudManager.perspective));
		this.modButtons.add(new ModButton(210, 90, 42, mc.fontRendererObj.FONT_HEIGHT + 5, Fireclient.INSTANCE.hudManager.armor));
		
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		for(ModButton m : modButtons) {
			m.draw();
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}
}
