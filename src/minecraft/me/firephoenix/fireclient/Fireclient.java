package me.firephoenix.fireclient;

import me.firephoenix.fireclient.cosmetics.CosmeticSusanoo;
import me.firephoenix.fireclient.event.EventManager;
import me.firephoenix.fireclient.event.EventTarget;
import me.firephoenix.fireclient.event.impl.ClientTick;
import me.firephoenix.fireclient.hud.HUDConfigScreen;
import me.firephoenix.fireclient.hud.mod.HudManager;
import me.firephoenix.fireclient.mod.ModManager;
import me.firephoenix.fireclient.ui.clickgui.ClickGUI;
import me.firephoenix.fireclient.util.SessionChanger;
import me.firephoenix.fireclient.util.config.Config;
import net.minecraft.client.Minecraft;

public class Fireclient {

	public String NAME = "Fireclient", VERSION = "1.0.0", AUTHOR = "Firephoenix", NAMEVER = NAME + " " + VERSION;
	public static Fireclient INSTANCE = new Fireclient();
	public Minecraft mc = Minecraft.getMinecraft();

	public EventManager eventManager;
	public Config config;
	public ModManager modManager;
	public HudManager hudManager;

	public void startup() {
		eventManager = new EventManager();
		config = new Config();
		config.loadModConfig();
		modManager = new ModManager();
		hudManager = new HudManager();


		SessionChanger.getInstance().setUserOffline("DevAcc");


		System.out.println("Starting " + NAMEVER + " " + "by " + AUTHOR);

		eventManager.register(this);
		mc.gameSettings.gammaSetting = 120f;
	}

	public void shutdown() {
		System.out.println("Shutting down " + NAMEVER);

		config.saveModConfig();

		eventManager.unregister(this);
	}

	@EventTarget
	public void onTick(ClientTick event) {
		//if (mc.gameSettings.HUD_CONFIG.isPressed()) {
			//mc.displayGuiScreen(new HUDConfigScreen());
		//}
		if (mc.gameSettings.CLICK_GUI.isPressed()) {
			//mc.displayGuiScreen(new ClickGUI());
			mc.displayGuiScreen(new HUDConfigScreen());
		}
	}

}
