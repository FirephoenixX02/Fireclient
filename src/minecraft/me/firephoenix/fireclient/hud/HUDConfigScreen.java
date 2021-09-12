package me.firephoenix.fireclient.hud;

import java.io.IOException;

import me.firephoenix.fireclient.Fireclient;
import me.firephoenix.fireclient.hud.mod.HudMod;
import me.firephoenix.fireclient.ui.clickgui.ClickGUI;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class HUDConfigScreen extends GuiScreen {
	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(new GuiButton(6340, this.width / 2 - 50, this.height / 2 - 10, 100, 20, "ClickGUI"));
		this.buttonList.add(new GuiButton(6341, this.width / 2 - 50, this.height / 2 + 20, 100, 20, "Cosmetics"));
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();

		for (HudMod m : Fireclient.INSTANCE.hudManager.hudMods) {
			if (m.isEnabled()) {
				m.renderDummy(mouseX, mouseY);
			}
		}

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);

		switch (button.id) {
		case 6340:
			mc.displayGuiScreen(new ClickGUI());
		}
	}
}
